package jp.co.clockvoid.chaser.feature.home.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.co.clockvoid.chaser.feature.home.CigaretteFragment

@Module
abstract class HomeModule {
    @ContributesAndroidInjector
    abstract fun contributesCigaretteFragment(): CigaretteFragment
}
