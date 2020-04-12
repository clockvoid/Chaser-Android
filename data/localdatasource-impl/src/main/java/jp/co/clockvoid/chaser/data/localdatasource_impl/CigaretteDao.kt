package jp.co.clockvoid.chaser.data.localdatasource_impl

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import jp.co.clockvoid.chaser.core.model.Smoke

@Dao
interface CigaretteDao {

    @Query("SELECT * FROM smoke_log")
    fun getSmokeLog(): List<SmokeEntity>

    @Insert
    fun registerSmokeLog(smoke: SmokeEntity)
}
