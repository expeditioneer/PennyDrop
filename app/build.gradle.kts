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
        compose = true
        dataBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
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
    implementation(Libraries.JetPack.compose_foundation)
    implementation(Libraries.JetPack.compose_ui)
    implementation(Libraries.JetPack.coreKtx)
    implementation(Libraries.JetPack.constraintLayoutCompose)
    implementation(Libraries.JetPack.lifecycleLivedata)
    implementation(Libraries.JetPack.lifecycleViewmodel)
    implementation(Libraries.JetPack.navigationUiKtx)
    implementation(Libraries.JetPack.navigationFragment)
    implementation(Libraries.JetPack.preferenceKtx)
    implementation(Libraries.JetPack.recyclerview)
    implementation(Libraries.JetPack.roomKtx)
    implementation(Libraries.JetPack.roomRuntime)
    implementation("androidx.activity:activity-compose:1.9.1")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.8")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.8")

    implementation(Libraries.Google.hilt)
    implementation(Libraries.Google.material)

    kapt(Libraries.Google.hiltCompiler)
    kapt(Libraries.JetPack.roomCompiler)

    testImplementation(TestLibraries.junit)

    androidTestImplementation(TestLibraries.AndroidXTest.junit)
    androidTestImplementation(TestLibraries.AndroidXTest.espressoCore)
}

kapt {
    correctErrorTypes = true
}
