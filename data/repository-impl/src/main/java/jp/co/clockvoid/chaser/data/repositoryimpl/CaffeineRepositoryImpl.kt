package jp.co.clockvoid.chaser.data.repositoryimpl

import jp.co.clockvoid.chaser.core.model.Boost
import jp.co.clockvoid.chaser.core.model.BoostType
import jp.co.clockvoid.chaser.data.localdatasource.CaffeineLocalDataSource
import jp.co.clockvoid.chaser.data.repository.CaffeineRepository
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

class CaffeineRepositoryImpl @Inject constructor(
    private val localDataSource: CaffeineLocalDataSource
): CaffeineRepository {

    override suspend fun boost(date: ZonedDateTime, type: BoostType) {
        localDataSource.registerBoostLog(Boost(type, date))
    }

    override suspend fun getBoostOfDay(date: LocalDate): List<Boost> {
        return localDataSource.getBoostLog()
            .filter { boost ->
                boost.timeStamp.toLocalDate() == date
            }
    }
}
