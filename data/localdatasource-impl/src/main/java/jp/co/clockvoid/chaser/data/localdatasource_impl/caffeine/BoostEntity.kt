package jp.co.clockvoid.chaser.data.localdatasource_impl.caffeine

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.ZonedDateTime

@Entity(tableName = "boost_log")
data class BoostEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "timeStamp") val timeStamp: ZonedDateTime
)
