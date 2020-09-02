package jp.co.clockvoid.chaser.feature.caffeine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.viewbinding.BindableItem
import dagger.hilt.android.AndroidEntryPoint
import jp.co.clockvoid.chaser.core.android.SpacingItemDecoration
import jp.co.clockvoid.chaser.feature.caffeine.databinding.FragmentCaffeineBinding
import kotlinx.coroutines.launch
import org.threeten.bp.Duration
import org.threeten.bp.ZonedDateTime

@AndroidEntryPoint
class CaffeineFragment : Fragment() {

    private val viewModel: CaffeineViewModel by viewModels()
    private var _binding: FragmentCaffeineBinding? = null
    private val binding
        get() = _binding!!
    private val items = mutableMapOf<Int, BindableItem<out ViewBinding>?>(
        TIME to null,
        NUMBER to null
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCaffeineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = GroupAdapter<GroupieViewHolder>()

        binding.analyticsCaffeineRecyclerView.also {
            it.adapter = adapter
            it.addItemDecoration(SpacingItemDecoration(8))
        }

        fetchNumberOfBoost(adapter)

        binding.boostFloatingActionButton.setOnClickListener {
            doBoost(adapter)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private fun doBoost(adapter: GroupAdapter<GroupieViewHolder>) {
        viewLifecycleOwner.lifecycleScope.launch {
            binding.boostFloatingActionButton.isEnabled = false
            runCatching {
                viewModel.boost(ZonedDateTime.now())
            }.onSuccess {
                fetchNumberOfBoost(adapter)
            }.onFailure {
                Snackbar.make(
                    binding.root,
                    it.localizedMessage ?: getString(R.string.an_error_occured),
                    Snackbar.LENGTH_SHORT
                ).setAnchorView(binding.boostFloatingActionButton)
                    .show()
            }
            binding.boostFloatingActionButton.isEnabled = true
        }
    }

    private fun fetchNumberOfBoost(adapter: GroupAdapter<GroupieViewHolder>) {
        viewLifecycleOwner.lifecycle.coroutineScope.launch {
            runCatching {
                viewModel.getBoostOfToday()
            }.onSuccess { boosts ->
                items[NUMBER] = NumberItem(boosts.size)
                boosts.map { boost -> boost.timeStamp }.maxOrNull()?.let { lastBoostTime ->
                    items[TIME] = TimeItem(Duration.between(lastBoostTime, ZonedDateTime.now()))
                }
                adapter.update(items.values.toList().filterNotNull())
            }.onFailure {
                Snackbar.make(
                    binding.root,
                    it.localizedMessage ?: getString(R.string.an_error_occured),
                    Snackbar.LENGTH_SHORT
                ).setAnchorView(binding.boostFloatingActionButton)
                    .show()
            }
        }
    }

    companion object {
        private const val TIME = 0
        private const val NUMBER = 1
    }
}
