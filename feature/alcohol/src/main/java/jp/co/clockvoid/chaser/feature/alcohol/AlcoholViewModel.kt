package jp.co.clockvoid.chaser.feature.alcohol

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import jp.co.clockvoid.chaser.data.repository.AlcoholRepository
import jp.co.clockvoid.chaser.feature.alcohol.model.AlcoholItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime

class AlcoholViewModel @ViewModelInject constructor(
    private val repository: AlcoholRepository,
    @ApplicationContext private val  context: Context,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val alcoholItem: MutableState<List<AlcoholItem>> = mutableStateOf(emptyList())

    suspend fun drink(date: ZonedDateTime) {
        withContext(Dispatchers.IO) {
            repository.drink(date)
        }
    }

    suspend fun getDrinkNumberOfDay(date: LocalDate) {
        withContext(Dispatchers.IO) {
            val list = repository.getDrinkLogOfDay(date)
            val item = AlcoholItem(
                title = "今日のアルコール量",
                body = context.getString(R.string.number_format, list.size),
                sentimentLevel = when (list.size) {
                    in 0..1 -> 0
                    in 2..3 -> 1
                    else -> 2
                }
            )
            withContext(Dispatchers.Main) {
                alcoholItem.value = listOf(item)
            }
        }
    }
}
