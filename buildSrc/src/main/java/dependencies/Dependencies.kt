package dependencies

@Suppress("unused")
object Dependencies {
    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:4.0.0"
    }

    object Kotlin {
        private const val version = "1.3.61"

        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${version}"
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

        object Navigation {
            private const val version = "2.2.1"

            const val fragment = "androidx.navigation:navigation-fragment:$version"
            const val ui = "androidx.navigation:navigation-ui:$version"
            const val gradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"

            object Ktx {
                const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
                const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            }
        }

        const val constraint = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val ktx = "androidx.core:core-ktx:1.2.0"
        const val material = "com.google.android.material:material:1.1.0"
    }

    object Groupie {
        private const val version = "2.8.0"
        const val runtime = "com.xwray:groupie:$version"
        const val ktx = "com.xwray:groupie-kotlin-android-extensions:$version"
        const val viewBinding = "com.xwray:groupie-viewbinding:$version"
    }

    object Room {
        private const val version = "2.2.5"
        const val runtime = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"
        const val test = "androidx.room:room-testing:$version"
    }

    object Dagger {
        private const val version = "2.25.2"
        const val dagger = "com.google.dagger:dagger:$version"
        const val android = "com.google.dagger:dagger-android:$version"
        const val androidSupport = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
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

    const val threeTen = "com.jakewharton.threetenabp:threetenabp:1.2.1"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.0"
}
