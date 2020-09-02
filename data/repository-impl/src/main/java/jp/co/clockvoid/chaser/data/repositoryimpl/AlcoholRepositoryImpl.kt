package jp.co.clockvoid.chaser.data.repositoryimpl

import jp.co.clockvoid.chaser.core.model.Drink
import jp.co.clockvoid.chaser.data.localdatasource.AlcoholLocalDataSource
import jp.co.clockvoid.chaser.data.repository.AlcoholRepository
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

class AlcoholRepositoryImpl @Inject constructor(
    private val localDataSource: AlcoholLocalDataSource
) : AlcoholRepository {

    override suspend fun drink(date: ZonedDateTime) {
        localDataSource.registerDrinkLog(Drink(date))
    }

    override suspend fun getDrinkLogOfDay(date: LocalDate): List<Drink> {
        return localDataSource.getDrinkLog().filter { drink ->
            drink.timestamp.toLocalDate() == date
        }
    }
}
