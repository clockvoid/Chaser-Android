package jp.co.clockvoid.chaser.feature.cigarette

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.android.support.DaggerFragment
import jp.co.clockvoid.chaser.core.android.FragmentExtension.dataBinding
import jp.co.clockvoid.chaser.core.android.SpacingItemDecoration
import jp.co.clockvoid.chaser.feature.cigarette.databinding.FragmentCigaretteBinding
import kotlinx.coroutines.launch
import org.threeten.bp.Duration
import javax.inject.Inject

class CigaretteFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: CigaretteViewModel by viewModels { viewModelFactory }
    private val binding: FragmentCigaretteBinding by dataBinding(R.layout.fragment_cigarette)
    private val adapter = GroupAdapter<GroupieViewHolder>()

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
        lifecycleScope.launch {
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
        lifecycleScope.launch {
            kotlin.runCatching {
                viewModel.getSmokeOfToday().size
            }.onSuccess {
                adapter.update(listOf(TimeItem(Duration.ofHours(100)), NumberItem(it)))
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
}
