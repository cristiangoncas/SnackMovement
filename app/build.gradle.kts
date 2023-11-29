plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt") version "1.9.10"
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.cristiangoncas.snackmovement"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cristiangoncas.snackmovement"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
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
        dataBinding = true
    }
}

dependencies {
    val coreKtxVersion = "1.9.0"
    val appcompatVersion = "1.6.1"
    val materialVersion = "1.9.0"
    val constraintlayoutVersion = "2.1.4"
    val navVersion = "2.7.3"
    val safeArgsVersion = "2.7.3"
    val roomVersion = "2.4.2"
    val koinAndroidVersion = "3.5.0"

    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("com.google.android.material:material:$materialVersion")
    implementation("androidx.constraintlayout:constraintlayout:$constraintlayoutVersion")
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("io.insert-koin:koin-android:$koinAndroidVersion")
    implementation("io.insert-koin:koin-androidx-navigation:$koinAndroidVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    val jUnitVersion = "4.13.2"
    val extJUnitVestion = "1.1.5"
    val espressoVersion = "3.5.1"

    testImplementation("junit:junit:$jUnitVersion")
    androidTestImplementation("androidx.test.ext:junit:$extJUnitVestion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
}
