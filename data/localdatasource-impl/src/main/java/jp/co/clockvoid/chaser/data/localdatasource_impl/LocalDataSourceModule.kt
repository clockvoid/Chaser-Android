package jp.co.clockvoid.chaser.data.localdatasource_impl

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import jp.co.clockvoid.chaser.data.localdatasource.CigaretteLocalDataSource

@Suppress("unused")
@InstallIn(ApplicationComponent::class)
@Module
abstract class LocalDataSourceModule {

    companion object {

        @Provides
        fun provideCigaretteDatabase(application: Application): CigaretteDatabase {
            return Room.databaseBuilder(
                application.applicationContext,
                CigaretteDatabase::class.java, "cigarette_database"
            ).build()
        }
    }

    @Binds
    protected abstract fun bindCigaretteLocalDataSource(impl: CigaretteLocalDataSourceImpl): CigaretteLocalDataSource
}
