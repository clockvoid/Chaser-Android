package jp.co.clockvoid.chaser.core.model

data class HttpError(
    override val message: String,
    val code: Int
): Throwable()
