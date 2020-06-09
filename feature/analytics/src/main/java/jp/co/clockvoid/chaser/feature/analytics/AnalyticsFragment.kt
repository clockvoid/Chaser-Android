package jp.co.clockvoid.chaser.feature.analytics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import jp.co.clockvoid.chaser.core.android.extensions.FragmentExtension.dataBinding
import jp.co.clockvoid.chaser.feature.analytics.databinding.FragmentAnalyticsBinding

class AnalyticsFragment : DaggerFragment() {

    private val binding by dataBinding<FragmentAnalyticsBinding>(R.layout.fragment_analytics)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}
