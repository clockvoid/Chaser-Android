package jp.co.clockvoid.chaser.feature.alcohol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.Recomposer
import androidx.fragment.app.Fragment
import androidx.ui.core.setContent

class AlcoholFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView = inflater.inflate(R.layout.fragment_alcohol, container, false)
        (fragmentView as ViewGroup).setContent(Recomposer.current()) {
            TutorialPreviewTemplate()
        }
        return fragmentView
    }
}
