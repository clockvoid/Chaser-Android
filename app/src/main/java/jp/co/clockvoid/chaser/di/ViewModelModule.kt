package jp.co.clockvoid.chaser.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import jp.co.clockvoid.chaser.feature.home.di.HomeViewModelModule

@Suppress("unused")
@Module(includes = [
    HomeViewModelModule::class
])
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
