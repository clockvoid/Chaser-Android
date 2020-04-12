package jp.co.clockvoid.chaser.data.localdatasource_impl

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides

@Module
abstract class LocalDateSourceModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideCigaretteDatabase(application: Application): CigaretteDatabase {
            return Room.databaseBuilder(
                application.applicationContext,
                CigaretteDatabase::class.java, "cigarette_database"
            ).build()
        }

        @Provides
        @JvmStatic
        fun provideCigaretteDao(database: CigaretteDatabase): CigaretteDao {
            return database.cigaretteDao()
        }
    }
}
