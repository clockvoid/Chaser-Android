
import dependencies.Versions
import dependencies.Dependencies

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    buildToolsVersion = Versions.buildToolsVersion

    defaultConfig {
        applicationId = "jp.co.clockvoid.chaser"
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        encoding = "UTF-8"
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:android"))
    implementation(project(":data:repository-impl"))
    implementation(project(":data:localdatasource-impl"))
    implementation(project(":feature:cigarette"))
    implementation(project(":feature:analytics"))
    implementation(project(":feature:alcohol"))

    // dagger
    kapt(Dependencies.Dagger.compiler)
    implementation(Dependencies.Dagger.Hilt.runtime)
    kapt(Dependencies.Dagger.Hilt.compiler)

    // hyperion
    debugImplementation(Dependencies.Hyperion.core)
    debugImplementation(Dependencies.Hyperion.attr)
    debugImplementation(Dependencies.Hyperion.buildConfig)
    debugImplementation(Dependencies.Hyperion.crash)
    debugImplementation(Dependencies.Hyperion.disk)
    debugImplementation(Dependencies.Hyperion.geigerCounter)
    debugImplementation(Dependencies.Hyperion.measurement)
    debugImplementation(Dependencies.Hyperion.performances)
    debugImplementation(Dependencies.Hyperion.phoenix)
    debugImplementation(Dependencies.Hyperion.recorder)
    debugImplementation(Dependencies.Hyperion.timber)

    // leak canary
    debugImplementation(Dependencies.leakCanary)

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
