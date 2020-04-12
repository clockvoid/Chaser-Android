package jp.co.clockvoid.chaser.data.localdatasource_impl

import androidx.room.TypeConverter
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

object ZonedDateTimeConverter {

    private val formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME

    @TypeConverter
    @JvmStatic
    fun toZonedDateTime(value: String?): ZonedDateTime? {
        return value?.let {
            return formatter.parse(value, ZonedDateTime::from)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromZonedDateTime(date: ZonedDateTime?): String? {
        return date?.format(formatter)
    }
}
