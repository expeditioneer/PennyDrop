plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "dev.lamm.pennydrop"
    compileSdk = AndroidSDK.compile

    defaultConfig {
        applicationId = "dev.lamm.pennydrop"
        minSdk = AndroidSDK.min
        targetSdk = AndroidSDK.target
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    kotlin {
        jvmToolchain(17)
    }

    hilt {
        enableAggregatingTask = true
    }
}

dependencies {
    implementation(Libraries.JetPack.appcompat)
    implementation(Libraries.JetPack.coreKtx)
    implementation(Libraries.JetPack.hilt)
    implementation(Libraries.JetPack.material)
    implementation(Libraries.JetPack.constrainedLayout)
    implementation(Libraries.JetPack.lifecycleLivedata)
    implementation(Libraries.JetPack.lifecycleViewmodel)
    implementation(Libraries.JetPack.navigationUiKtx)
    implementation(Libraries.JetPack.navigationFragment)
    implementation(Libraries.JetPack.preferenceKtx)
    implementation(Libraries.JetPack.recyclerview)
    implementation(Libraries.JetPack.roomKtx)
    implementation(Libraries.JetPack.roomRuntime)

    kapt(Libraries.JetPack.hiltCompiler)
    kapt(Libraries.JetPack.roomCompiler)

    testImplementation(TestLibraries.junit)

    androidTestImplementation(TestLibraries.AndroidXTest.junit)
    androidTestImplementation(TestLibraries.AndroidXTest.espressoCore)
}

kapt {
    correctErrorTypes = true
}
