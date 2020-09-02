package jp.co.clockvoid.chaser.data.localdatasource_impl.cigarette

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CigaretteDao {

    @Query("SELECT * FROM smoke_log")
    fun getSmokeLog(): List<SmokeEntity>

    @Insert
    fun registerSmokeLog(smoke: SmokeEntity)
}
