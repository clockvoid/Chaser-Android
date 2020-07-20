package jp.co.clockvoid.chaser.di

import dagger.android.AndroidInjector
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import jp.co.clockvoid.chaser.ChaserApp

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface AppComponent : AndroidInjector<ChaserApp>
