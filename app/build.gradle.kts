plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 33

    namespace = "plus.naomi.hook"

    defaultConfig {
        applicationId = "plus.naomi.hook"
        minSdk = 31
        targetSdk = 33
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        named("release") {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles("proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.majorVersion
    }

    splits {
        abi {
            isEnable = true
            reset()
            include("armeabi-v7a", "arm64-v8a")
            isUniversalApk = false
        }
    }
}

dependencies {
    compileOnly("de.robv.android.xposed:api:82")
    implementation("org.luckypray:DexKit:1.1.4")
    implementation("com.github.kyuubiran:EzXHelper:2.0.0-RC7")
}
