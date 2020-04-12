package jp.co.clockvoid.chaser.data.localdatasource_impl

import androidx.room.CoroutinesRoom
import jp.co.clockvoid.chaser.core.model.Smoke
import jp.co.clockvoid.chaser.data.localdatasource.CigaretteLocalDataSource
import java.util.concurrent.Callable
import javax.inject.Inject

class CigaretteLocalDataSourceImpl @Inject constructor(
    private val cigaretteDatabase: CigaretteDatabase
) : CigaretteLocalDataSource {

    override suspend fun getSmokeLog(): List<Smoke> {
        return CoroutinesRoom.execute(cigaretteDatabase, false, Callable<List<Smoke>> {
            cigaretteDatabase.cigaretteDao().getSmokeLog().map {
                Smoke(number = it.number, timeStamp = it.timeStamp)
            }
        })
    }

    override suspend fun registerSmokeLog(smoke: Smoke) {
        CoroutinesRoom.execute(cigaretteDatabase, false, Callable<Unit> {
            cigaretteDatabase.cigaretteDao().registerSmokeLog(SmokeEntity(null, smoke.number, smoke.timeStamp))
        })
    }
}
