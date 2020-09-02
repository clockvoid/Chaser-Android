package jp.co.clockvoid.chaser.data.localdatasource_impl.alcohol

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import jp.co.clockvoid.chaser.data.localdatasource_impl.ZonedDateTimeConverter

@Database(entities = [DrinkEntity::class], version = 1, exportSchema = false)
@TypeConverters(ZonedDateTimeConverter::class)
abstract class AlcoholDatabase : RoomDatabase() {
    abstract fun alcoholDao(): AlcoholDao
}
