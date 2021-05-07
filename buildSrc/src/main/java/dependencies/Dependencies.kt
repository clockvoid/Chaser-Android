package dependencies

@Suppress("unused")
object Dependencies {

    object GradlePlugin {

        const val android = "com.android.tools.build:gradle:7.0.0-alpha15"
        const val licenseReport = "com.jaredsburrows:gradle-license-plugin:0.8.90"
    }

    object Kotlin {
        // see: https://kotlinlang.org/docs/releases.html#release-details

        @Suppress("unused")
        const val version = "1.4.31"

        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object KotlinX {

        object Coroutine {

            private const val version = "1.4.2"

            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }

        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.1.0"
    }

    object AndroidX {
        // see: https://developer.android.com/jetpack/androidx/versions/all-channel

        object AppCompat {

            private const val version = "1.2.0"

            const val runtime = "androidx.appcompat:appcompat:$version"
        }

        object Hilt {

            private const val version = "1.0.0"

            const val common = "androidx.hilt:hilt:$version"
        }

        object Navigation {

            private const val version = "2.3.5"

            const val fragment = "androidx.navigation:navigation-fragment:$version"
            const val ui = "androidx.navigation:navigation-ui:$version"
            const val gradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"

            object Ktx {

                const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
                const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            }
        }

        object Room {

            private const val version = "2.3.0"

            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val test = "androidx.room:room-testing:$version"
        }

        object Compose {

            const val version = "1.0.0-beta02"

            const val animation = "androidx.compose.animation:animation:$version"

            object Foundation {

                const val runtime = "androidx.compose.foundation:foundation:$version"
                const val layout =  "androidx.compose.foundation:foundation-layout:$version"
            }

            object Material {

                const val runtime = "androidx.compose.material:material:$version"
                const val icons = "androidx.compose.material:material-icons-extended:$version"
                const val themeAdapter = "com.google.android.material:compose-theme-adapter:$version"
            }

            object Runtime {

                const val runtime = "androidx.compose.runtime:runtime:$version"
                const val livedata = "androidx.compose.runtime:runtime-livedata:$version"
            }

            object Ui {

                const val runtime = "androidx.compose.ui:ui:$version"
                const val tooling = "androidx.compose.ui:ui-tooling:$version"
            }
        }

        object ConstraintLayout {

            const val runtime = "androidx.constraintlayout:constraintlayout:2.0.4"
            const val compose = "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha03"
        }

        const val ktx = "androidx.core:core-ktx:1.3.2"
        const val material = "com.google.android.material:material:1.3.0"
    }

    object Groupie {

        private const val version = "2.9.0"

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

        private const val version = "2.35.1"

        const val dagger = "com.google.dagger:dagger:$version"
        const val android = "com.google.dagger:dagger-android:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"

        object Hilt {

            private const val version = "2.35.1"

            const val runtime = "com.google.dagger:hilt-android:$version"
            const val compiler = "com.google.dagger:hilt-android-compiler:$version"
            const val plugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        }
    }

    object Hyperion {

        private const val version = "0.9.31"

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

    const val threeTen = "com.jakewharton.threetenabp:threetenabp:1.3.0"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.6"
    const val timber = "com.jakewharton.timber:timber:4.7.1"
}
