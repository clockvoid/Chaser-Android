package jp.co.clockvoid.chaser.feature.cigarette

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.google.android.material.snackbar.Snackbar
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.viewbinding.BindableItem
import dagger.hilt.android.AndroidEntryPoint
import jp.co.clockvoid.chaser.components.setting.SettingActivity
import jp.co.clockvoid.chaser.core.android.SpacingItemDecoration
import jp.co.clockvoid.chaser.feature.cigarette.databinding.FragmentCigaretteBinding
import jp.co.clockvoid.chaser.feature.cigarette.extensions.FragmentExtension.dataBinding
import kotlinx.coroutines.launch
import org.threeten.bp.Duration
import org.threeten.bp.ZonedDateTime

@AndroidEntryPoint
class CigaretteFragment : Fragment() {

    private val viewModel: CigaretteViewModel by viewModels()
    private val binding: FragmentCigaretteBinding by dataBinding(R.layout.fragment_cigarette)
    private val adapter = GroupAdapter<GroupieViewHolder>()
    private val items = mutableMapOf<Int, BindableItem<out ViewBinding>?>(
        CHART to ChartContainerItem(),
        TIME to null,
        NUMBER to null
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolBar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_setting -> {
                    startActivity(SettingActivity.from(requireActivity()))
                    true
                }
                else -> {
                    false
                }
            }
        }

        binding.analyticsCigaretteRecyclerView.also {
            it.adapter = adapter
            it.addItemDecoration(SpacingItemDecoration(8))
        }

        fetchNumberOfSmoke()

        binding.smokeFloatingActionButton.setOnClickListener {
            MaterialDialog(requireContext()).show {
                input(inputType = InputType.TYPE_CLASS_NUMBER, prefill = "1") { _, text ->
                    doSmoke(text.toString().toInt())
                }
                title(text = "吸った本数を入力してください")
                positiveButton(text = "OK")
            }
            MaterialDialog
        }
    }

    private fun doSmoke(number: Int) {
        viewLifecycleOwner.lifecycleScope.launch {
            binding.smokeFloatingActionButton.isEnabled = false
            kotlin.runCatching {
                viewModel.smoke(number)
            }.onSuccess {
                fetchNumberOfSmoke()
            }.onFailure {
                Snackbar.make(
                    binding.root,
                    it.localizedMessage ?: getString(R.string.an_error_occured),
                    Snackbar.LENGTH_SHORT
                ).setAnchorView(binding.smokeFloatingActionButton)
                    .show()
            }
            binding.smokeFloatingActionButton.isEnabled = true
        }
    }

    private fun fetchNumberOfSmoke() {
        viewLifecycleOwner.lifecycleScope.launch {
            kotlin.runCatching {
                viewModel.getSmokeOfToday()
            }.onSuccess {
                items[NUMBER] = NumberItem(it.fold(0) { acc, smoke -> acc + smoke.number })
                it.map { smoke -> smoke.timeStamp }.maxOrNull()?.let { lastSmokedTime ->
                    items[TIME] = TimeItem(Duration.between(lastSmokedTime, ZonedDateTime.now()))
                }
                adapter.update(items.values.toList().filterNotNull())
            }.onFailure {
                Snackbar.make(
                    binding.root,
                    it.localizedMessage ?: getString(R.string.an_error_occured),
                    Snackbar.LENGTH_SHORT
                ).setAnchorView(binding.smokeFloatingActionButton)
                    .show()
            }
        }
    }

    companion object {
        private const val CHART = 0
        private const val TIME = 1
        private const val NUMBER = 2
    }
}
