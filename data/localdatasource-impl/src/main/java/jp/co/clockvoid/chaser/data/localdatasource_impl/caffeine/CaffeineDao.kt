package jp.co.clockvoid.chaser.data.localdatasource_impl.caffeine

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CaffeineDao {

    @Query("SELECT * FROM smoke_log")
    fun getBoostLog(): List<CaffeineEntity>

    @Insert
    fun registerBoostLog(smoke: CaffeineEntity)
}
