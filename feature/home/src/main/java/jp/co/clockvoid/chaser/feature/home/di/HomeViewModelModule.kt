package jp.co.clockvoid.chaser.feature.home.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import jp.co.clockvoid.chaser.core.android.di.ViewModelKey
import jp.co.clockvoid.chaser.feature.cigarette.CigaretteViewModel

@Suppress("unused")
@Module
abstract class HomeViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CigaretteViewModel::class)
    abstract fun bindCigaretteViewModel(viewModel: CigaretteViewModel): ViewModel
}
