package jp.co.clockvoid.chaser.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Singleton

@DisableInstallInCheck
@Module
abstract class AppModule {

    companion object {

        @Singleton
        @Provides
        fun provideAppContext(application: Application): Context {
            return application
        }
    }
}
