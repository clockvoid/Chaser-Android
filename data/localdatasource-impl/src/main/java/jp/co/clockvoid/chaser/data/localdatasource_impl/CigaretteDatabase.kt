package jp.co.clockvoid.chaser.data.localdatasource_impl

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

// TODO: 多分そのうちデータベースをエクスポートするようになるが，一旦incremental buildを有効にするためにexportSchemaをfalseにしている
@Database(entities = [SmokeEntity::class], version = 1, exportSchema = false)
@TypeConverters(ZonedDateTimeConverter::class)
abstract class CigaretteDatabase : RoomDatabase() {
    abstract fun cigaretteDao(): CigaretteDao
}
