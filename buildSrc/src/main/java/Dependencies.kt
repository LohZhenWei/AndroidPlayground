object Apps {
    const val compileSdk = 31
    const val minSdk = 23
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val kotlin = "1.5.20"
    const val ktx = "1.7.0"
}

object Library {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinKtx = "androidx.core:core-ktx:${Versions.ktx}"
}
