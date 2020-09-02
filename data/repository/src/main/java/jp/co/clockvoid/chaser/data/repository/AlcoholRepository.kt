package jp.co.clockvoid.chaser.data.repository

import jp.co.clockvoid.chaser.core.model.Drink
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime

interface AlcoholRepository {

    suspend fun drink(date: ZonedDateTime)

    suspend fun getDrinkLogOfDay(date: LocalDate): List<Drink>
}
