package jp.co.clockvoid.chaser.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import jp.co.clockvoid.chaser.core.android.di.ViewModelFactory

@Suppress("unused")
@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
