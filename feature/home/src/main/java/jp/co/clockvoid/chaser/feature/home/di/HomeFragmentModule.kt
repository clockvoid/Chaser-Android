package jp.co.clockvoid.chaser.feature.home.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.co.clockvoid.chaser.feature.cigarette.CigaretteFragment

@Suppress("unused")
@Module
abstract class HomeFragmentModule {
    @ContributesAndroidInjector
    internal abstract fun contributesCigaretteFragment(): CigaretteFragment
}
