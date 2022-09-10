plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("my-plugin")
}

android {
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
/*    kotlinOptions {
        jvmTarget = "1.8"
    }*/
}

dependencies {
    implementation(project(":library"))
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
}