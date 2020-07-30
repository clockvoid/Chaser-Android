package jp.co.clockvoid.chaser.di

import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import jp.co.clockvoid.chaser.data.localdatasource_impl.LocalDataSourceModule
import jp.co.clockvoid.chaser.data.repositoryimpl.RepositoryModule

@InstallIn(ApplicationComponent::class)
@Module(includes = [
    AppModule::class,
    AndroidInjectionModule::class,
    LocalDataSourceModule::class,
    RepositoryModule::class,
    ViewModelModule::class
])
interface AggregatorModule
