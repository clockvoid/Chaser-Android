package jp.co.clockvoid.chaser.feature.caffeine

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.clockvoid.chaser.core.model.Boost
import jp.co.clockvoid.chaser.core.model.BoostType
import jp.co.clockvoid.chaser.data.repository.CaffeineRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

@HiltViewModel
class CaffeineViewModel @Inject constructor(
    private val repository: CaffeineRepository
): ViewModel() {

    suspend fun getBoostOfToday(): List<Boost> {
        return withContext(Dispatchers.IO) {
            repository.getBoostOfDay(LocalDate.now())
        }
    }

    suspend fun boost(date: ZonedDateTime, type: BoostType) {
        withContext(Dispatchers.IO) {
            repository.boost(date, type)
        }
    }
}
