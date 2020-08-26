package jp.co.clockvoid.chaser.data.localdatasource_impl.cigarette

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import jp.co.clockvoid.chaser.data.localdatasource_impl.ZonedDateTimeConverter

// TODO: 多分そのうちデータベースをエクスポートするようになるが，一旦incremental buildを有効にするためにexportSchemaをfalseにしている
@Database(entities = [SmokeEntity::class], version = 1, exportSchema = false)
@TypeConverters(ZonedDateTimeConverter::class)
abstract class CigaretteDatabase : RoomDatabase() {
    abstract fun cigaretteDao(): CigaretteDao
}
