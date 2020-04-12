package jp.co.clockvoid.chaser.data.localdatasource_impl

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [SmokeEntity::class], version = 1)
@TypeConverters(ZonedDateTimeConverter::class)
abstract class CigaretteDatabase : RoomDatabase() {
    abstract fun cigaretteDao(): CigaretteDao
}
