package jp.co.clockvoid.chaser.feature.home.di

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
abstract class HomeModule {
    @ContributesAndroidInjector
    internal abstract fun contributesCigaretteFragment(): CigaretteFragment

    @Binds
    @IntoMap
    @ViewModelKey(CigaretteViewModel::class)
    abstract fun bindCigaretteViewModel(viewModel: CigaretteViewModel): ViewModel
}
