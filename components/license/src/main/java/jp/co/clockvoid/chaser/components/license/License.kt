package jp.co.clockvoid.chaser.components.license

import android.content.Context
import android.content.Intent

object License {

    fun launch(context: Context) {
        context.startActivity(newIntent(context))
    }

    private fun newIntent(context: Context): Intent {
        return LicenseListActivity.newIntent(context)
    }
}
