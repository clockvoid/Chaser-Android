package jp.co.clockvoid.chaser.feature.alcohol

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.setContent
import androidx.fragment.app.Fragment
import androidx.ui.tooling.preview.Preview
import com.google.android.material.composethemeadapter.MdcTheme
import dagger.hilt.android.AndroidEntryPoint
import jp.co.clockvoid.chaser.feature.alcohol.model.AlcoholItem
import jp.co.clockvoid.chaser.feature.alcohol.ui.AlcoholFragmentBody

@AndroidEntryPoint
class AlcoholFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FrameLayout(requireContext()).apply {
            setContent(Recomposer.current()) {
                MdcTheme {
                    AlcoholFragmentBody(mutableStateOf(emptyList()))
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}

@Preview
@Composable
fun AlcoholFragmentPreview() {
    MdcTheme {
        AlcoholFragmentBody(mutableStateOf(listOf(
            AlcoholItem(
                title = "最後に吸ってから",
                body = "12時間",
                sentimentLevel = 1
            )
        )))
    }
}
