package jp.co.clockvoid.chaser.data.localdatasource

import jp.co.clockvoid.chaser.core.model.Smoke

interface CigaretteLocalDataSource {

    suspend fun getSmokeLog(): List<Smoke>

    suspend fun registerSmokeLog(smoke: Smoke)
}
