package jp.co.clockvoid.chaser.components.license

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import jp.co.clockvoid.chaser.components.license.databinding.ActivityComponentLicenseHtmlBinding

internal class LicenseHtmlActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_HTML = "license.html.path"

        fun newIntent(context: Context, htmlPath: String) = Intent(
            context,
            LicenseHtmlActivity::class.java
        ).apply {
            putExtra(EXTRA_HTML, htmlPath)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityComponentLicenseHtmlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.web.loadUrl(intent.getStringExtra(EXTRA_HTML))
    }
}
