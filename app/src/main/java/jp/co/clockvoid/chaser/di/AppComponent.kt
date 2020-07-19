package jp.co.clockvoid.chaser.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import jp.co.clockvoid.chaser.ChaserApp
import jp.co.clockvoid.chaser.data.localdatasource_impl.LocalDataSourceModule
import jp.co.clockvoid.chaser.data.repositoryimpl.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        LocalDataSourceModule::class,
        RepositoryModule::class,
        MainActivityModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<ChaserApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
