package jp.co.clockvoid.chaser.feature.cigarette

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.viewbinding.BindableItem
import dagger.android.support.DaggerFragment
import jp.co.clockvoid.chaser.core.android.FragmentExtension.dataBinding
import jp.co.clockvoid.chaser.core.android.SpacingItemDecoration
import jp.co.clockvoid.chaser.feature.cigarette.databinding.FragmentCigaretteBinding
import kotlinx.coroutines.launch
import org.threeten.bp.Duration
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

class CigaretteFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: CigaretteViewModel by viewModels { viewModelFactory }
    private val binding: FragmentCigaretteBinding by dataBinding(R.layout.fragment_cigarette)
    private val adapter = GroupAdapter<GroupieViewHolder>()
    private val items = mutableMapOf<Int, BindableItem<out ViewBinding>?>(
        TIME to null,
        NUMBER to null
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.analyticsCigaretteRecyclerView.also {
            it.adapter = adapter
            it.addItemDecoration(SpacingItemDecoration(8))
        }

        fetchNumberOfSmoke()

        binding.smokeFloatingActionButton.setOnClickListener {
            doSmoke()
        }
    }

    private fun doSmoke() {
        viewLifecycleOwner.lifecycleScope.launch {
            binding.smokeFloatingActionButton.isEnabled = false
            kotlin.runCatching {
                viewModel.smoke()
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
                items[NUMBER] = NumberItem(it.size)
                it.map { smoke -> smoke.timeStamp }.max()?.let { lastSmokedTime ->
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
        private const val TIME = 0
        private const val NUMBER = 1
    }
}
