object BuildPlugins {
    val androidApplication  by lazy { "com.android.application" }
    val androidLibrary by lazy { "com.android.library" }
    val kotlinAndroid by lazy { "org.jetbrains.kotlin.android" }
}

object Libraries {
    object JetPack {
        val appcompat by lazy { "androidx.appcompat:appcompat:1.5.1" }
        val constrainedLayout by lazy { "androidx.constraintlayout:constraintlayout:2.1.4" }
        val coreKtx by lazy { "androidx.core:core-ktx:1.8.0" }
        val material by lazy { "com.google.android.material:material:1.7.0" }
    }
}

object TestLibraries {
    val junit by lazy { "junit:junit:4.13.2" }

    object AndroidXTest {
        val espressoCore by lazy { "androidx.test.espresso:espresso-core:3.4.0" }
        val junit by lazy { "androidx.test.ext:junit:1.1.3" }
    }
}