package jp.co.clockvoid.chaser.feature.cigarette

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import jp.co.clockvoid.chaser.data.repository.CigaretteRepository
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime

class CigaretteViewModel @ViewModelInject constructor(
    private val repository: CigaretteRepository
) : ViewModel() {

    suspend fun smoke() = repository.smoke(ZonedDateTime.now())

    suspend fun getSmokeOfToday() = repository.getSmokeOfDay(LocalDate.now())
}
