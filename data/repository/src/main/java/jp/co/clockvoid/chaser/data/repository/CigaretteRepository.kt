package jp.co.clockvoid.chaser.data.repository

import jp.co.clockvoid.chaser.core.model.Smoke
import kotlinx.coroutines.flow.Flow
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime

interface CigaretteRepository {

    suspend fun smoke(date: ZonedDateTime, number: Int)

    suspend fun getSmokeOfDay(date: LocalDate): List<Smoke>

    suspend fun getSmokeOfWeek(startDate: LocalDate): Flow<List<Smoke>>

    suspend fun getSmokeOfMonth(startDate: LocalDate): Flow<List<Smoke>>
}
