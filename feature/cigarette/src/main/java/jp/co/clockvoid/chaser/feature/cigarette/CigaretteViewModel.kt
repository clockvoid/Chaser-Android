package jp.co.clockvoid.chaser.feature.cigarette

import androidx.lifecycle.ViewModel
import jp.co.clockvoid.chaser.data.repository.CigaretteRepository
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

class CigaretteViewModel @Inject constructor(
    private val repository: CigaretteRepository
) : ViewModel() {

    suspend fun smoke() = repository.smoke(ZonedDateTime.now())

    suspend fun getSmokeOfToday() = repository.getSmokeOfDay(LocalDate.now())
}
