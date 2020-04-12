package jp.co.clockvoid.chaser.data.repositoryimpl

import dagger.Binds
import dagger.Module
import jp.co.clockvoid.chaser.data.repository.CigaretteRepository
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    protected abstract fun bindCigaretteRepository(impl: CigaretteRepositoryImpl): CigaretteRepository
}
