package jp.co.clockvoid.chaser

import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import jp.co.clockvoid.chaser.di.AppComponent
import jp.co.clockvoid.chaser.di.DaggerAppComponent

class ChaserApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    // Instance of the AppComponent that will be used by all the Activities int the project.
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent(): AppComponent {
        // Create an instance of AppComponent using its Factory constructor.
        // We pass the applicationContext that will be used as Context in the graph.
        return DaggerAppComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this);
    }
}
