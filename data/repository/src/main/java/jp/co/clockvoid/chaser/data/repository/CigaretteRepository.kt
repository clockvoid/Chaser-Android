package jp.co.clockvoid.chaser.data.repository

import jp.co.clockvoid.chaser.core.model.Smoke
import kotlinx.coroutines.flow.Flow
import org.threeten.bp.LocalDate

interface CigaretteRepository {
    suspend fun smoke(data: Smoke): Flow<Unit>

    suspend fun getSmokeOfDay(date: LocalDate): Flow<List<Smoke>>

    suspend fun getSmokeOfWeek(startDate: LocalDate): Flow<List<Smoke>>

    suspend fun getSmokeOfMonth(startDate: LocalDate): Flow<List<Smoke>>
}
