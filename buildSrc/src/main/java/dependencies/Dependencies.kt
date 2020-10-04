package dependencies

@Suppress("unused")
object Dependencies {
    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:4.2.0-alpha13"
    }

    object Kotlin {
        private const val version = "1.4.0"

        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object KotlinX {
        object Coroutine {
            private const val version = "1.3.2"

            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }
    }

    object AndroidX {
        object AppCompat {
            private const val version = "1.1.0"

            const val runtime = "androidx.appcompat:appcompat:$version"
        }

        object Hilt {
            private const val version = "1.0.0-alpha02"

            const val common = "androidx.hilt:hilt-common:$version"
            const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
            const val compiler = "androidx.hilt:hilt-compiler:$version"
        }

        object Navigation {
            private const val version = "2.3.0"

            const val fragment = "androidx.navigation:navigation-fragment:$version"
            const val ui = "androidx.navigation:navigation-ui:$version"
            const val gradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"

            object Ktx {
                const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
                const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            }
        }

        object Room {
            private const val version = "2.2.5"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val test = "androidx.room:room-testing:$version"
        }

        const val constraint = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val ktx = "androidx.core:core-ktx:1.3.1"
        const val material = "com.google.android.material:material:1.1.0"
    }

    object Groupie {
        private const val version = "2.8.0"
        const val runtime = "com.xwray:groupie:$version"
        const val ktx = "com.xwray:groupie-kotlin-android-extensions:$version"
        const val viewBinding = "com.xwray:groupie-viewbinding:$version"
    }

    object MaterialDialogs {
        private const val version = "3.3.0"

        const val core = "com.afollestad.material-dialogs:core:$version"
        const val input = "com.afollestad.material-dialogs:input:$version"
        const val color = "com.afollestad.material-dialogs:color:$version"
        const val lifecycle = "com.afollestad.material-dialogs:lifecycle:$version"
    }

    object Dagger {
        private const val version = "2.28.3"
        const val dagger = "com.google.dagger:dagger:$version"
        const val android = "com.google.dagger:dagger-android:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"

        object Hilt {
            private const val version = "2.28-alpha"
            const val runtime = "com.google.dagger:hilt-android:$version"
            const val compiler = "com.google.dagger:hilt-android-compiler:$version"
            const val plugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        }
    }

    object GmsOssLicense {
        const val gradlePlugin = "com.google.android.gms:oss-licenses-plugin:0.10.2"
        const val runtime = "com.google.android.gms:play-services-oss-licenses:17.0.0"
    }

    object Hyperion {
        private const val version = "0.9.27"
        const val core = "com.willowtreeapps.hyperion:hyperion-core:$version"
        const val attr = "com.willowtreeapps.hyperion:hyperion-attr:$version"
        const val buildConfig = "com.willowtreeapps.hyperion:hyperion-build-config:$version"
        const val crash = "com.willowtreeapps.hyperion:hyperion-crash:$version"
        const val disk = "com.willowtreeapps.hyperion:hyperion-disk:$version"
        const val geigerCounter = "com.willowtreeapps.hyperion:hyperion-geiger-counter:$version"
        const val measurement = "com.willowtreeapps.hyperion:hyperion-measurement:$version"
        const val phoenix = "com.willowtreeapps.hyperion:hyperion-phoenix:$version"
        const val recorder = "com.willowtreeapps.hyperion:hyperion-recorder:$version"
        const val performances = "com.willowtreeapps.hyperion:hyperion-shared-preferences:$version"
        const val timber = "com.willowtreeapps.hyperion:hyperion-timber:$version"
    }

    const val threeTen = "com.jakewharton.threetenabp:threetenabp:1.2.4"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.4"
    const val timber = "com.jakewharton.timber:timber:4.7.1"
}
