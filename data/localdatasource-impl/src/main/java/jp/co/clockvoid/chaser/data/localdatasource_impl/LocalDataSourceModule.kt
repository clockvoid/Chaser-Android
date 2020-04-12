package jp.co.clockvoid.chaser.data.localdatasource_impl

import android.app.Application
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import jp.co.clockvoid.chaser.data.localdatasource.CigaretteLocalDataSource
import javax.inject.Singleton

@Module
abstract class LocalDataSourceModule {
    @Module
    companion object {
        @Provides
        @Singleton
        @JvmStatic
        fun provideCigaretteDatabase(application: Application): CigaretteDatabase {
            return Room.databaseBuilder(
                application.applicationContext,
                CigaretteDatabase::class.java, "cigarette_database"
            ).build()
        }
    }

    @Binds
    @Singleton
    protected abstract fun bindCigaretteLocalDataSource(impl: CigaretteLocalDataSourceImpl): CigaretteLocalDataSource
}
