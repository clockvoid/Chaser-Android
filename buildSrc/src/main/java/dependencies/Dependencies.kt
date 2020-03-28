package dependencies

@Suppress("unused")
object Dependencies {
    object Kotlin {
        val stdlib = { version: String -> "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version" }
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
}
