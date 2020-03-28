package jp.co.clockvoid.chaser.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideAppContext(application: Application): Context {
            return application
        }

        @Provides
        @Singleton
        @JvmStatic
        fun provideTestString(): String {
            return "hello"
        }
    }
}
