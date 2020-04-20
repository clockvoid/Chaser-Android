package jp.co.clockvoid.chaser.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.co.clockvoid.chaser.feature.home.MainActivity
import jp.co.clockvoid.chaser.feature.home.di.HomeFragmentModule

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            HomeFragmentModule::class
        ]
    )
    internal abstract fun contributeMainActivity(): MainActivity
}
