package jp.co.clockvoid.chaser.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import jp.co.clockvoid.chaser.feature.cigarette.di.CigaretteViewModelModule

@Suppress("unused")
@DisableInstallInCheck
@Module(includes = [
    CigaretteViewModelModule::class
])
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
