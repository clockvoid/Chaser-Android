package jp.co.clockvoid.chaser.data.localdatasource_impl.caffeine

import androidx.room.CoroutinesRoom
import jp.co.clockvoid.chaser.core.model.Boost
import jp.co.clockvoid.chaser.core.model.BoostType
import jp.co.clockvoid.chaser.data.localdatasource.CaffeineLocalDataSource
import java.util.concurrent.Callable
import javax.inject.Inject

class CaffeineLocalDataSourceImpl @Inject constructor(
    private val caffeineDatabase: CaffeineDatabase
) : CaffeineLocalDataSource {

    override suspend fun getBoostLog(): List<Boost> {
        return CoroutinesRoom.execute(caffeineDatabase, false, Callable {
            caffeineDatabase.caffeineDao().getBoostLog().map {
                Boost(type = BoostType.valueOf(it.type), timeStamp = it.timeStamp)
            }
        })
    }

    override suspend fun registerBoostLog(boost: Boost) {
        CoroutinesRoom.execute(caffeineDatabase, false, Callable {
            caffeineDatabase.caffeineDao().registerBoostLog(
                BoostEntity(null, boost.type.rawValue, boost.timeStamp)
            )
        })
    }
}
