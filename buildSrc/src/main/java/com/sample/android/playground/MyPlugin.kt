package com.sample.android.playground

import Apps
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.api.AndroidBasePlugin
import com.android.build.gradle.internal.plugins.LibraryPlugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler

class MyPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        target.plugins.all {
            when (this) {
                is LibraryPlugin -> {
                    val extension = target.extensions.getByType(LibraryExtension::class.java)
                    //  extension.configurePlugin()
                }
                /*  is KotlinBasePluginWrapper -> {
                      target.tasks.withType(KotlinCompile::class.java).configureEach { compile ->
                          compile.kotlinOptions.allWarningsAsErrors = true
                          compile.kotlinOptions.jvmTarget = "1.8"
                      }
                  }*/
            }
        }
        val androidExtension = target.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                // Java 8
                compileSdkVersion(Apps.compileSdk)
                defaultConfig {
                    targetSdk = Apps.targetSdk
                    minSdk = Apps.minSdk
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
                dataBinding {
                    isEnabled = true
                }
                packagingOptions {
                    //   setExcludes(setOf("META-INF/NOTICE.txt",))
                }
                /*   target.tasks.withType(KotlinCompile::class.java).configureEach {
                       kotlinOptions {
                           jvmTarget = "1.8"
                       }
                   }*/

                /*   buildTypes {
                       getByName("release") {
                           isMinifyEnabled = false
                           proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
                       }

                       getByName("debug") {
                           isTestCoverageEnabled = true
                       }
                   }*/
                /* target.tasks.withType<KotlinCompile> {
                     kotlinOptions.jvmTarget = "1.8"
                 }


                 target.tasks.withType(KotlinCompile::class.java).configureEach {
                     kotlinOptions {
                         jvmTarget = "1.8"
                     }
                 }*/
            }
        }

        target.plugins.apply {
            apply("dagger.hilt.android.plugin")
            apply("kotlin-kapt")
        }

        target.configureAndroid()

        target.dependencies.apply {
            implementation("androidx.core:core-ktx:1.7.0")
            implementation("androidx.appcompat:appcompat:1.4.1")
            implementation("com.google.android.material:material:1.5.0")
            implementation("androidx.activity:activity-ktx:1.6.0-alpha01")
            implementation("androidx.fragment:fragment-ktx:1.4.1")

            //hilt
            implementation("com.google.dagger:hilt-android:2.40.5")
            kapt("com.google.dagger:hilt-android-compiler:2.40.5")
            implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
            implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
            //Timber
            implementation("com.jakewharton.timber:timber:4.7.1")
        }
    }

    private fun Project.containAndroidPlugin(): Boolean {
        return project.plugins.toList().any { plugin -> plugin is AndroidBasePlugin }
    }

    private fun Project.configureAndroid() {

    }

    private fun DependencyHandler.implementation(dependencyNotation: String) {
        add("implementation", dependencyNotation)
    }

    private fun DependencyHandler.kapt(dependencyNotation: String) {
        add("kapt", dependencyNotation)
    }
}
