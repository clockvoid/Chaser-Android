package jp.co.clockvoid.chaser.core.model

import org.threeten.bp.ZonedDateTime

data class Boost(
    val type: BoostType,
    val timeStamp: ZonedDateTime
)

enum class BoostType(val rawValue: String, val displayName: String) {

    TEA("tea", "お茶"),
    COFFEE("coffee", "コーヒー"),
    ENERGY_DRINK("energy_drink", "エナジードリンク"),
    VAPE("vape", "ペイプ"),
    OTHER("other", "その他");

    companion object {
        fun from(value: String): BoostType {
            return values().findLast { it.rawValue == value }!!
        }
    }
}
