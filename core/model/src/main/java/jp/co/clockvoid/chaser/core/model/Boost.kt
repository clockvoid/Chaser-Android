package jp.co.clockvoid.chaser.core.model

import org.threeten.bp.ZonedDateTime

data class Boost(
    val type: BoostType,
    val timeStamp: ZonedDateTime
)

enum class BoostType(val rawValue: String) {

    TEA("tea"),
    COFFEE("coffee"),
    ENERGY_DRINK("energy_drink"),
    VAPE("vape"),
    OTHER("other");

    companion object {
        fun from(value: String): BoostType {
            return values().findLast { it.rawValue == value }!!
        }
    }
}
