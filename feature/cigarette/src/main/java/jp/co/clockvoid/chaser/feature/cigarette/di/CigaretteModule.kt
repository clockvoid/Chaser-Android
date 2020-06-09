package jp.co.clockvoid.chaser.feature.cigarette.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import jp.co.clockvoid.chaser.core.android.di.ViewModelKey
import jp.co.clockvoid.chaser.feature.cigarette.CigaretteFragment
import jp.co.clockvoid.chaser.feature.cigarette.CigaretteViewModel

@Suppress("unused")
@Module
abstract class CigaretteFragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributesCigaretteFragment(): CigaretteFragment
}

@Suppress("unused")
@Module
abstract class CigaretteViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CigaretteViewModel::class)
    abstract fun bindCigaretteViewModel(viewModel: CigaretteViewModel): ViewModel
}