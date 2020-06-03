package jp.co.clockvoid.chaser.feature.analytics.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.co.clockvoid.chaser.feature.analytics.AnalyticsFragment

@Suppress("unused")
@Module
abstract class AnalyticsFragmentModule {

    @ContributesAndroidInjector
    internal abstract fun contributesAnalyticsFragment(): AnalyticsFragment
}
