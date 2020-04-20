package jp.co.clockvoid.chaser.feature.cigarette

import androidx.lifecycle.ViewModel
import jp.co.clockvoid.chaser.data.repository.CigaretteRepository
import javax.inject.Inject

class CigaretteViewModel @Inject constructor(
    private val repository: CigaretteRepository
) : ViewModel() {
    val test = "test"
}
