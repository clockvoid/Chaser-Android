
import dependencies.Dependencies
import dependencies.Versions

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")

    // https://github.com/jmatsu/license-list-plugin
    id("io.github.jmatsu.license-list") version ("0.6.1")
    id("com.google.android.gms.oss-licenses-plugin")
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

    // solution to https://issuetracker.google.com/issues/170026127
    // There is a bug around lint tool that is bundled with AGP 4.2.0-alpha13
    lintOptions {
        disable("InvalidFragmentVersionForActivityResult")
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
    implementation(project(":components:setting"))
    implementation(project(":components:license"))
    implementation(project(":feature:cigarette"))
    implementation(project(":feature:caffeine"))
    implementation(project(":feature:alcohol"))

    // dagger
    kapt(Dependencies.Dagger.compiler)
    implementation(Dependencies.Dagger.Hilt.runtime)
    kapt(Dependencies.Dagger.Hilt.compiler)
    implementation(Dependencies.AndroidX.Hilt.viewModel)

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

    implementation(Dependencies.GmsOssLicense.runtime)

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}

// https://github.com/jmatsu/license-list-plugin#extension
licenseList {
    defaultVariant = "release"

    variants {

        create("release") {
            baseDir = file("license-list")

            assembly {
                format = "yaml"
                style = "structured"
            }

            visualization {
                format = "html"
            }
        }
    }
}
