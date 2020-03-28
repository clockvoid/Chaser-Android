package jp.co.clockvoid.chaser.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerFragment
import jp.co.clockvoid.chaser.feature.home.databinding.FragmentCigaretteBinding

class CigaretteFragment : DaggerFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return (DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_cigarette,
            container,
            false
        ) as FragmentCigaretteBinding).root
    }
}
