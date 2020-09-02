package jp.co.clockvoid.chaser.data.localdatasource

import jp.co.clockvoid.chaser.core.model.Boost

interface CaffeineLocalDataSource {

    suspend fun getBoostLog(): List<Boost>

    suspend fun registerBoostLog(boost: Boost)
}
