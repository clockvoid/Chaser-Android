package jp.co.clockvoid.chaser.data.localdatasource_impl.alcohol

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.ZonedDateTime

@Entity(tableName = "drink_log")
data class DrinkEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "timeStamp") val timeStamp: ZonedDateTime
)
