package jp.co.clockvoid.chaser.data.repositoryimpl

import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import jp.co.clockvoid.chaser.data.repository.CigaretteRepository
import javax.inject.Singleton

@Suppress("unused")
@DisableInstallInCheck
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    protected abstract fun bindCigaretteRepository(impl: CigaretteRepositoryImpl): CigaretteRepository
}
