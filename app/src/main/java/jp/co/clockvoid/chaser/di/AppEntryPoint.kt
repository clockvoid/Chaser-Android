package jp.co.clockvoid.chaser.di

import dagger.android.AndroidInjector
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.clockvoid.chaser.ChaserApp

@EntryPoint
@InstallIn(SingletonComponent::class)
interface AppEntryPoint : AndroidInjector<ChaserApp>
