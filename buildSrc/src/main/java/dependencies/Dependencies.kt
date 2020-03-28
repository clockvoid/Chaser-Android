package dependencies

@Suppress("unused")
object Dependencies {
    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:3.6.1"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    }

    object Kotlin {
        const val version = "1.3.61"

        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
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

        const val constraint = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val ktx = "androidx.core:core-ktx:1.1.0"
    }

    const val threeTen = "com.jakewharton.threetenabp:threetenabp:1.2.1"
}
