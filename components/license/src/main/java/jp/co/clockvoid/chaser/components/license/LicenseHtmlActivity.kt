package jp.co.clockvoid.chaser.components.license

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.afollestad.materialdialogs.utils.MDUtil.textChanged
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
                    if (binding.searchEditText.isVisible) {
                        binding.searchEditText.isGone = true
                        binding.searchEditText.clearFocus()
                        item.setIcon(R.drawable.ic_baseline_search_24)
                        hideSoftKeyboard(binding.searchEditText)
                    } else {
                        binding.searchEditText.isVisible = true
                        item.setIcon(R.drawable.ic_baseline_close_24)
                        showSoftKeyboard(binding.searchEditText)
                    }
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

        binding.searchEditText.textChanged {
            lifecycleScope.launchWhenStarted {
                viewModel.filterQuery.value = it.toString()
            }
        }

        viewModel.getPackageLicenseList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun showSoftKeyboard(view: View) {

        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    private fun hideSoftKeyboard(view: View) {

        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
