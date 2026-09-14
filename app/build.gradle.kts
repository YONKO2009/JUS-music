plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.jusmusic"
    compileSdk = 36
    defaultConfig {
        applicationId = "com.jusmusic"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
}

dependencies {
    implementation("androidx.navigation:navigation-compose:2.8.5")
}
