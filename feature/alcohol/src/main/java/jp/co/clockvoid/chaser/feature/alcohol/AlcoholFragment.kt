package jp.co.clockvoid.chaser.feature.alcohol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.setContent
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.composethemeadapter.MdcTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AlcoholFragment : Fragment() {

    private val alcoholItem1 = AlcoholItem(
        title = "最後に吸ってから",
        body = "12時間",
        sentimentLevel = 1
    )

    private val alcoholItem2 = AlcoholItem(
        title = "最後に吸ってから",
        body = "15時間",
        sentimentLevel = 2
    )

    private val items = mutableStateOf(listOf(alcoholItem1, alcoholItem2))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FrameLayout(requireContext()).apply {
            setContent(Recomposer.current()) {
                MdcTheme {
                    TutorialPreviewTemplate(items)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO) {
            delay(1000)

            lifecycleScope.launch(Dispatchers.Main) {
                items.value = listOf(alcoholItem2)
            }
        }
    }
}
