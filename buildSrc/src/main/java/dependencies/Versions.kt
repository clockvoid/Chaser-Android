package dependencies

@Suppress("unused")
object Versions {
    @SuppressWarnings("WeakerAccess")
    const val compileSdkVersion: Int = 29
    const val minSdkVersion: Int = 23
    const val targetSdkVersion: Int = compileSdkVersion
    const val buildToolsVersion: String = "30.0.2"

    private const val versionMajor: Int = 1
    private const val versionMinor: Int = 0
    private const val versionPatch: Int = 0
    private const val versionOffset: Int = 0

    const val versionCode =
        (versionMajor * 10000 + versionMinor * 100 + versionPatch) * 100 + versionOffset
    const val versionName = "$versionMajor.$versionMinor.$versionPatch"
}
