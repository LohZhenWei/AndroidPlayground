include(
    ":app",
    ":library"
)
rootProject.name = "AndroidPlayground"
include(":feature-one")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
