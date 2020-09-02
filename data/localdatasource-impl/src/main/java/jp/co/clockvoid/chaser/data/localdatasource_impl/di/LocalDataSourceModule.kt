package jp.co.clockvoid.chaser.data.localdatasource_impl.di

import android.app.Application
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import jp.co.clockvoid.chaser.data.localdatasource.AlcoholLocalDataSource
import jp.co.clockvoid.chaser.data.localdatasource.CaffeineLocalDataSource
import jp.co.clockvoid.chaser.data.localdatasource.CigaretteLocalDataSource
import jp.co.clockvoid.chaser.data.localdatasource_impl.alcohol.AlcoholDatabase
import jp.co.clockvoid.chaser.data.localdatasource_impl.alcohol.AlcoholLocalDataSourceImpl
import jp.co.clockvoid.chaser.data.localdatasource_impl.caffeine.CaffeineDatabase
import jp.co.clockvoid.chaser.data.localdatasource_impl.caffeine.CaffeineLocalDataSourceImpl
import jp.co.clockvoid.chaser.data.localdatasource_impl.cigarette.CigaretteDatabase
import jp.co.clockvoid.chaser.data.localdatasource_impl.cigarette.CigaretteLocalDataSourceImpl

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

        @Provides
        fun provideCaffeineDatabase(application: Application): CaffeineDatabase {
            return Room.databaseBuilder(
                application.applicationContext,
                CaffeineDatabase::class.java, "caffeine_database"
            ).build()
        }

        @Provides
        fun provideAlcoholDatabase(application: Application): AlcoholDatabase {
            return Room.databaseBuilder(
                application.applicationContext,
                AlcoholDatabase::class.java, "alcohol_database"
            ).build()
        }
    }

    @Binds
    protected abstract fun bindCigaretteLocalDataSource(impl: CigaretteLocalDataSourceImpl): CigaretteLocalDataSource

    @Binds
    protected abstract fun bindCaffeineLocalDataSource(impl: CaffeineLocalDataSourceImpl): CaffeineLocalDataSource

    @Binds
    protected abstract fun bindAlcoholLocalDataSource(impl: AlcoholLocalDataSourceImpl): AlcoholLocalDataSource
}
