package jp.co.clockvoid.chaser.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import jp.co.clockvoid.chaser.data.repository.CigaretteRepository
import jp.co.clockvoid.chaser.data.repositoryimpl.CigaretteRepositoryImpl
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
    @Module
    companion object {
        @Provides
        @Singleton
        @JvmStatic
        fun provideCigaretteRepositoryImpl() = CigaretteRepositoryImpl()
    }

    @Binds
    @Singleton
    abstract fun bindsCigaretteRepository(impl: CigaretteRepositoryImpl): CigaretteRepository
}
