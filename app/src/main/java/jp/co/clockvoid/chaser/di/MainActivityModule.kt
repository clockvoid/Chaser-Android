package jp.co.clockvoid.chaser.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.co.clockvoid.chaser.feature.home.MainActivity

@Module
internal abstract class MainActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
}
