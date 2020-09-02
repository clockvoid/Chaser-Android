package jp.co.clockvoid.chaser.data.localdatasource_impl.alcohol

import androidx.room.CoroutinesRoom
import jp.co.clockvoid.chaser.core.model.Drink
import jp.co.clockvoid.chaser.data.localdatasource.AlcoholLocalDataSource
import java.util.concurrent.Callable
import javax.inject.Inject

class AlcoholLocalDataSourceImpl @Inject constructor(
    private val alcoholDatabase: AlcoholDatabase
) : AlcoholLocalDataSource {

    override suspend fun getDrinkLog(): List<Drink> {
        return CoroutinesRoom.execute(alcoholDatabase, false, Callable {
            alcoholDatabase.alcoholDao().getDrinkLog().map {
                Drink(timestamp = it.timeStamp)
            }
        })
    }

    override suspend fun registerDrinkLog(drink: Drink) {
        return CoroutinesRoom.execute(alcoholDatabase, false, Callable {
            alcoholDatabase.alcoholDao().registerDrinkLog(
                DrinkEntity(
                    id = null,
                    timeStamp = drink.timestamp
                )
            )
        })
    }
}
