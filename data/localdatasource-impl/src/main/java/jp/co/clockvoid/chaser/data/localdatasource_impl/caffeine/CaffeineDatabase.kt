package jp.co.clockvoid.chaser.data.localdatasource_impl.caffeine

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import jp.co.clockvoid.chaser.data.localdatasource_impl.ZonedDateTimeConverter
import jp.co.clockvoid.chaser.data.localdatasource_impl.cigarette.CigaretteDao
import jp.co.clockvoid.chaser.data.localdatasource_impl.cigarette.SmokeEntity

@Database(entities = [SmokeEntity::class], version = 1, exportSchema = false)
@TypeConverters(ZonedDateTimeConverter::class)
abstract class CaffeineDatabase : RoomDatabase() {
    abstract fun caffeineDao(): CaffeineDao
}
