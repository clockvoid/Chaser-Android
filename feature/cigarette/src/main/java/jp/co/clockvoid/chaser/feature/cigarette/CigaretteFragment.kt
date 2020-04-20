package jp.co.clockvoid.chaser.feature.cigarette

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import jp.co.clockvoid.chaser.core.android.FragmentExtension.dataBinding
import jp.co.clockvoid.chaser.feature.cigarette.databinding.FragmentCigaretteBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

class CigaretteFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: CigaretteViewModel by viewModels { viewModelFactory }
    private val binding: FragmentCigaretteBinding by dataBinding(R.layout.fragment_cigarette)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchNumberOfSmoke()

        binding.smokeFloatingActionButton.setOnClickListener {
            doSmoke()
        }
    }

    @ExperimentalCoroutinesApi
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
                    it.localizedMessage ?: "エラーが発生しました",
                    Snackbar.LENGTH_SHORT
                ).setAnchorView(binding.smokeFloatingActionButton)
                    .show()
            }
            binding.smokeFloatingActionButton.isEnabled = true
        }
    }

    private fun fetchNumberOfSmoke() {
        lifecycleScope.launch {
            binding.numberTextView.text = viewModel.getSmokeOfToday().size.toString()
        }
    }
}
