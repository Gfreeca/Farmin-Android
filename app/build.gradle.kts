plugins {
    id(Dependency.Plugins.APPLICATION)
    id(Dependency.Plugins.KOTLIN)
    id(Dependency.Plugins.HILT_PLUGIN)
    kotlin(Dependency.Plugins.KAPT)
}

@Suppress("UnstableApiUsage")
android {
    namespace = "com.gfreeca.farmin_android"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.gfreeca.farmin_android"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE)
    implementation(Dependency.Compose.ACTIVITY_COMPOSE)
    implementation(Dependency.Compose.COMPOSE_UI)
    implementation(Dependency.Compose.COMPOSE_UI_PREVIEW)
    implementation(Dependency.Compose.COMPOSE_MATERAIL)
    implementation(Dependency.Compose.NAVIGATION)
    implementation(Dependency.Google.PAGER)
    implementation(Dependency.AndroidX.LIFECYCLE_VIEWMODEL_KTX)
    testImplementation(Dependency.Test.JUNIT)
    androidTestImplementation(Dependency.Test.ANDROID_JUNIT)
    androidTestImplementation(Dependency.Test.ESPRESSO)
    androidTestImplementation(Dependency.Test.COMPOSE_TEST)
    debugImplementation(Dependency.Debug.COMPOSE_TOOLING)
    debugImplementation(Dependency.Debug.COMPOSE_MANIFEST)
    implementation("com.google.maps.android:maps-compose:2.11.4")
    implementation("com.google.android.gms:play-services-maps:18.1.0")

    //Hilt
    implementation(Dependency.Google.HILT)
    kapt(Dependency.Google.HILT_COMPILER)

    //Retrofit
    implementation(Dependency.Libraries.RETROFIT)
    implementation(Dependency.Libraries.RETROFIT_CONVERTER_GSON)
    implementation(Dependency.Libraries.OKHTTP)
    implementation(Dependency.Libraries.OKHTTP_LOGGING_INTERCEPTOR)

    //Coil
    implementation(Dependency.Libraries.COIL)
}
