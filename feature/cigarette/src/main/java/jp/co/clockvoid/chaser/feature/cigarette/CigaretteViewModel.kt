package jp.co.clockvoid.chaser.feature.cigarette

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.clockvoid.chaser.core.model.Smoke
import jp.co.clockvoid.chaser.data.repository.CigaretteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

@HiltViewModel
class CigaretteViewModel @Inject constructor(
    private val repository: CigaretteRepository
) : ViewModel() {

    suspend fun smoke(number: Int) {
        withContext(Dispatchers.IO) {
            repository.smoke(ZonedDateTime.now(), number)
        }
    }

    suspend fun getSmokeOfToday(): List<Smoke> {
        return withContext(Dispatchers.IO) {
            repository.getSmokeOfDay(LocalDate.now())
        }
    }
}
