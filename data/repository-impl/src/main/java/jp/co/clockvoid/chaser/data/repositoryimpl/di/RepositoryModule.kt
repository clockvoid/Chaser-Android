package jp.co.clockvoid.chaser.data.repositoryimpl.di

import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import jp.co.clockvoid.chaser.data.repository.CaffeineRepository
import jp.co.clockvoid.chaser.data.repository.CigaretteRepository
import jp.co.clockvoid.chaser.data.repositoryimpl.CaffeineRepositoryImpl
import jp.co.clockvoid.chaser.data.repositoryimpl.CigaretteRepositoryImpl
import javax.inject.Singleton

@Suppress("unused")
@DisableInstallInCheck
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    protected abstract fun bindCigaretteRepository(impl: CigaretteRepositoryImpl): CigaretteRepository

    @Binds
    @Singleton
    protected abstract fun bindCaffeineRepository(impl: CaffeineRepositoryImpl): CaffeineRepository
}
