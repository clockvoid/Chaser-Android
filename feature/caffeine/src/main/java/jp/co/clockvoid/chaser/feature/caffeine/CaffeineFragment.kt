package jp.co.clockvoid.chaser.feature.caffeine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jp.co.clockvoid.chaser.core.android.extensions.FragmentExtension.dataBinding
import jp.co.clockvoid.chaser.feature.caffeine.databinding.FragmentAnalyticsBinding

class CaffeineFragment : Fragment() {

    private val binding by dataBinding<FragmentAnalyticsBinding>(R.layout.fragment_analytics)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}
