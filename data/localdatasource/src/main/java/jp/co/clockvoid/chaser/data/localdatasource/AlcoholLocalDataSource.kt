package jp.co.clockvoid.chaser.data.localdatasource

import jp.co.clockvoid.chaser.core.model.Drink

interface AlcoholLocalDataSource {

    suspend fun getDrinkLog(): List<Drink>

    suspend fun registerDrinkLog(drink: Drink)
}
