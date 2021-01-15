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
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import com.google.android.material.composethemeadapter.MdcTheme
import dagger.hilt.android.AndroidEntryPoint
import jp.co.clockvoid.chaser.components.setting.SettingActivity
import jp.co.clockvoid.chaser.feature.alcohol.model.AlcoholItem
import jp.co.clockvoid.chaser.feature.alcohol.ui.AlcoholFragmentBody
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDate
import org.threeten.bp.ZonedDateTime
import timber.log.Timber

@AndroidEntryPoint
class AlcoholFragment : Fragment() {

    private val viewModel: AlcoholViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FrameLayout(requireContext()).apply {
            setContent(Recomposer.current()) {
                MdcTheme {
                    AlcoholFragmentBody(viewModel.alcoholItem, {
                        viewLifecycleOwner.lifecycle.coroutineScope.launch {
                            runCatching {
                                viewModel.drink(ZonedDateTime.now())
                            }.onSuccess {
                                viewModel.getDrinkNumberOfDay(LocalDate.now())
                            }.onFailure {
                                Timber.d(it)
                            }
                        }
                    }, {
                        startActivity(SettingActivity.from(requireActivity()))
                    })
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycle.coroutineScope.launch {
            runCatching {
                viewModel.getDrinkNumberOfDay(LocalDate.now())
            }.onFailure {
                Timber.e(it)
            }
        }
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
        )), {
        }, {
        })
    }
}
