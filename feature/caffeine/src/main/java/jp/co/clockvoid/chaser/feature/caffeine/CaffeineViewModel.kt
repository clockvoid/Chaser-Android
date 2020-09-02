package jp.co.clockvoid.chaser.feature.caffeine

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import jp.co.clockvoid.chaser.core.model.Boost
import jp.co.clockvoid.chaser.core.model.BoostType
import jp.co.clockvoid.chaser.data.repository.CaffeineRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime

class CaffeineViewModel @ViewModelInject constructor(
    private val repository: CaffeineRepository
): ViewModel() {

    suspend fun getBoostOfToday(): List<Boost> {
        return withContext(Dispatchers.IO) {
            repository.getBoostOfDay(LocalDate.now())
        }
    }

    suspend fun boost(date: ZonedDateTime, type: BoostType = BoostType.COFFEE) {
        withContext(Dispatchers.IO) {
            repository.boost(date, type)
        }
    }
}
