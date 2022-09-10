plugins {
    id("com.android.application")
    kotlin("android")
    id("androidx.navigation.safeargs.kotlin")
    id("my-plugin")
}

android {
    defaultConfig {
        applicationId = "com.sample.android.playground"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures.viewBinding = true
    buildFeatures.dataBinding = true

    // Allow references to generated code
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":library"))
    implementation(project(":feature-one"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.20")

    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")


    implementation("androidx.activity:activity-ktx:1.3.0-alpha05")
    implementation("androidx.fragment:fragment-ktx:1.3.2")

    //hilt
/*
    implementation("com.google.dagger:hilt-android:2.40.5")
    kapt("com.google.dagger:hilt-android-compiler:2.40.5")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
*/

    //Timber
    implementation("com.jakewharton.timber:timber:4.7.1")

    //Navigation Version
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.1")

/*    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0-alpha05")
    kapt("androidx.lifecycle:lifecycle-compiler:2.5.0-alpha05")*/


}