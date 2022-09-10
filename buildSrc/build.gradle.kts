import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.4.31"
    // `java-gradle-plugin`

}

gradlePlugin {
    plugins {
        register("my-plugin") {
            id = "my-plugin"
            implementationClass = "com.sample.android.playground.MyPlugin"
        }
    }
}
repositories {
    google()
    mavenCentral()
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.apiVersion = "1.3"
}

dependencies {
    //implementation("com.android.tools.build:gradle-api:7.1.3")
    implementation(kotlin("stdlib"))
    implementation("com.android.tools.build:gradle:7.0.4")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")

    implementation("com.squareup:javapoet:1.13.0")

    //implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
    //implementation(kotlin("android-extensions"))
    implementation(gradleApi())
    implementation(localGroovy())
}
