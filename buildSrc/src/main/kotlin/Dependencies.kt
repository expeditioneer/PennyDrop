object BuildPlugins {
    val androidApplication by lazy { "com.android.application" }
    val androidLibrary by lazy { "com.android.library" }
    val hilt by lazy { "com.google.dagger.hilt.android" }
    val kotlinAndroid by lazy { "org.jetbrains.kotlin.android" }
}

object Libraries {
    object JetPack {
        val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.Jetpack.APP_COMPAT}" }
        val compose_foundation by lazy { "androidx.compose.foundation:foundation:1.7.0-beta07"}
        val compose_ui by lazy { "androidx.compose.ui:ui:${Versions.Jetpack.COMPOSE}" }
        val constraintLayoutCompose by lazy { "androidx.constraintlayout:constraintlayout-compose:${Versions.Jetpack.CONSTRAINED_LAYOUT_COMPOSE}" }
        val coreKtx by lazy { "androidx.core:core-ktx:${Versions.Jetpack.CORE}" }
        val lifecycleLivedata by lazy { "androidx.lifecycle:lifecycle-livedata:${Versions.Jetpack.LIFECYCLE}" }
        val lifecycleViewmodel by lazy { "androidx.lifecycle:lifecycle-viewmodel:${Versions.Jetpack.LIFECYCLE}" }
        val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.Jetpack.NAVIGATION}" }
        val navigationUiKtx by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.Jetpack.NAVIGATION}" }
        val preferenceKtx by lazy { "androidx.preference:preference-ktx:${Versions.Jetpack.PREFERENCES}" }
        val recyclerview by lazy { "androidx.recyclerview:recyclerview:${Versions.Jetpack.RECYCLERVIEW}" }
        val roomKtx by lazy { "androidx.room:room-ktx:${Versions.Jetpack.ROOM}" }
        val roomRuntime by lazy { "androidx.room:room-runtime:${Versions.Jetpack.ROOM}" }
        val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.Jetpack.ROOM}" }
    }

    object Google {
        val hilt by lazy { "com.google.dagger:hilt-android:${Versions.Google.HILT}" }
        val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.Google.HILT}" }
        val material by lazy { "com.google.android.material:material:${Versions.Google.MATERIAL}" }
    }
}

object TestLibraries {
    val junit by lazy { "junit:junit:4.13.2" }

    object AndroidXTest {
        val espressoCore by lazy { "androidx.test.espresso:espresso-core:3.4.0" }
        val junit by lazy { "androidx.test.ext:junit:1.1.3" }
    }
}