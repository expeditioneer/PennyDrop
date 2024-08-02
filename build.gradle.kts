plugins {
    id(BuildPlugins.androidApplication) version Versions.BUILD_TOOLS apply false
    id(BuildPlugins.androidLibrary) version Versions.BUILD_TOOLS apply false
    id(BuildPlugins.kotlinAndroid) version Versions.KOTLIN apply false
    id(BuildPlugins.hilt) version Versions.Google.HILT apply false
}
