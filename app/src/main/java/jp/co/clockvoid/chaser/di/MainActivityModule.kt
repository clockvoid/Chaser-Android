package jp.co.clockvoid.chaser.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.co.clockvoid.chaser.feature.analytics.di.AnalyticsFragmentModule
import jp.co.clockvoid.chaser.feature.cigarette.di.CigaretteFragmentModule
import jp.co.clockvoid.chaser.view.home.MainActivity

@Suppress("unused")
@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(
        modules = [
            CigaretteFragmentModule::class,
            AnalyticsFragmentModule::class
        ]
    )
    internal abstract fun contributeMainActivity(): MainActivity
}
