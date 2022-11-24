plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
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

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Libraries.JetPack.appcompat)
    implementation(Libraries.JetPack.coreKtx)
    implementation(Libraries.JetPack.material)
    implementation(Libraries.JetPack.constrainedLayout)
    implementation(Libraries.JetPack.navigationUiKtx)
    implementation(Libraries.JetPack.navigationFragment)

    testImplementation(TestLibraries.junit)

    androidTestImplementation(TestLibraries.AndroidXTest.junit)
    androidTestImplementation(TestLibraries.AndroidXTest.espressoCore)
}
