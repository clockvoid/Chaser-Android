package jp.co.clockvoid.chaser.data.repository

import jp.co.clockvoid.chaser.core.model.Boost
import jp.co.clockvoid.chaser.core.model.BoostType
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime

interface CaffeineRepository {

    suspend fun boost(date: ZonedDateTime, type: BoostType)

    suspend fun getBoostOfDay(date: LocalDate): List<Boost>
}
