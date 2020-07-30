package jp.co.clockvoid.chaser.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.hilt.migration.DisableInstallInCheck
import jp.co.clockvoid.chaser.feature.cigarette.di.CigaretteFragmentModule
import jp.co.clockvoid.chaser.view.home.MainActivity

@Suppress("unused")
@DisableInstallInCheck
@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity
}
