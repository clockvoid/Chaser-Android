package jp.co.clockvoid.chaser.data.localdatasource_impl

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.ZonedDateTime

@Entity(tableName = "smoke_log")
data class SmokeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "number") val number: Int,
    @ColumnInfo(name = "timeStamp") val timeStamp: ZonedDateTime
)
