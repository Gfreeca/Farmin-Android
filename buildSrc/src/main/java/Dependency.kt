object Dependency {
    object Plugins {
        const val APPLICATION = "com.android.application"
        const val LIBRARY = "com.android.library"
        const val KOTLIN = "org.jetbrains.kotlin.android"
    }

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:1.7.0"
        const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    }

    object Compose {
        const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:1.3.1"
        const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
        const val COMPOSE_UI_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
        const val COMPOSE_MATERAIL = "androidx.compose.material:material:1.2.0"
    }

    object Test {
        const val JUNIT = "junit:junit:4.13.2"
        const val ANDROID_JUNIT = "androidx.test.ext:junit:1.1.5"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:3.5.1"
        const val COMPOSE_TEST = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
    }

    object Debug {
        const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
        const val COMPOSE_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE}"
    }
}