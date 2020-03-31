package jp.co.clockvoid.chaser.core.model

data class LocalStorageError(
    override val message: String
): Throwable()
