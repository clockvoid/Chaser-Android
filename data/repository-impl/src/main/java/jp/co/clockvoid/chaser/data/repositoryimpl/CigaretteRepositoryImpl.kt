package jp.co.clockvoid.chaser.data.repositoryimpl

import jp.co.clockvoid.chaser.core.model.Smoke
import jp.co.clockvoid.chaser.data.localdatasource.CigaretteLocalDataSource
import jp.co.clockvoid.chaser.data.repository.CigaretteRepository
import kotlinx.coroutines.flow.Flow
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

class CigaretteRepositoryImpl @Inject constructor(
    private val localDataSource: CigaretteLocalDataSource
) : CigaretteRepository {

    override suspend fun smoke(date: ZonedDateTime, number: Int) {
        return localDataSource.registerSmokeLog(Smoke(number, date))
    }

    override suspend fun getSmokeOfDay(date: LocalDate): List<Smoke> {
        return localDataSource.getSmokeLog().filter { smoke ->
            smoke.timeStamp.toLocalDate() == date
        }
    }

    override suspend fun getSmokeOfWeek(startDate: LocalDate): Flow<List<Smoke>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getSmokeOfMonth(startDate: LocalDate): Flow<List<Smoke>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
