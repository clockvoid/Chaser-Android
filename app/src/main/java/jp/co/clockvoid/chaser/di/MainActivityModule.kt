package jp.co.clockvoid.chaser.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.co.clockvoid.chaser.feature.home.MainActivity
import jp.co.clockvoid.chaser.feature.home.di.HomeModule

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            HomeModule::class
        ]
    )
    internal abstract fun contributeMainActivity(): MainActivity
}
