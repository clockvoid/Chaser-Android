package jp.co.clockvoid.chaser.components.license

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import jp.co.clockvoid.chaser.components.license.databinding.ActivityComponentLicenseHtmlBinding
import jp.co.clockvoid.chaser.core.android.SpacingItemDecoration
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LicenseHtmlActivity : AppCompatActivity() {

    companion object {

        private const val EXTRA_HTML = "license.html.path"

        fun newIntent(context: Context, htmlPath: String) = Intent(
            context,
            LicenseHtmlActivity::class.java
        ).apply {
            putExtra(EXTRA_HTML, htmlPath)
        }
    }

    private val viewModel: LicenseActivityViewModel by viewModels()
    private val adapter: LicenseListAdapter = LicenseListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityComponentLicenseHtmlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_search -> {
//                    binding.searchView.isVisible = true
                    true
                }
                else -> false
            }
        }

        binding.licenseListRecyclerView.also {
            it.adapter = adapter
            it.addItemDecoration(SpacingItemDecoration(8))
        }

        lifecycleScope.launchWhenStarted {
            viewModel.packageLicenseList.collect {
                adapter.submitList(it)
            }
        }

        viewModel.getPackageLicenseList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
