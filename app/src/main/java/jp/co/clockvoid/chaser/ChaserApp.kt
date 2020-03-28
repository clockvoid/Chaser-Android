package jp.co.clockvoid.chaser

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import jp.co.clockvoid.chaser.di.DaggerAppComponent

class ChaserApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}
