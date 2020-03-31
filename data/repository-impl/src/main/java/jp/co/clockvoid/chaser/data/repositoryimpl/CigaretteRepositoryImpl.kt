package jp.co.clockvoid.chaser.data.repositoryimpl

import jp.co.clockvoid.chaser.core.model.Smoke
import jp.co.clockvoid.chaser.data.repository.CigaretteRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.threeten.bp.LocalDate

class CigaretteRepositoryImpl : CigaretteRepository {
    override suspend fun smoke(data: Smoke): Flow<Unit> {
        return flow {
            delay(1000)
        }
    }

    override suspend fun getSmokeOfDay(date: LocalDate): Flow<List<Smoke>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getSmokeOfWeek(startDate: LocalDate): Flow<List<Smoke>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getSmokeOfMonth(startDate: LocalDate): Flow<List<Smoke>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
