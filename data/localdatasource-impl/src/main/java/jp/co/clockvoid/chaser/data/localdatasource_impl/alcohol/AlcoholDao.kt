package jp.co.clockvoid.chaser.data.localdatasource_impl.alcohol

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlcoholDao {

    @Query("SELECT * FROM drink_log")
    fun getDrinkLog(): List<DrinkEntity>

    @Insert
    fun registerDrinkLog(drink: DrinkEntity)
}
