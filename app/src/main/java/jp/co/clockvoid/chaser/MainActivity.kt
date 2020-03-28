package jp.co.clockvoid.chaser

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerAppCompatActivity
import jp.co.clockvoid.chaser.core.model.Smoke
import jp.co.clockvoid.chaser.data.repository.CigaretteRepository
import jp.co.clockvoid.chaser.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import org.threeten.bp.ZoneId
import org.threeten.bp.ZonedDateTime
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var testString: String
    @Inject
    lateinit var cigaretteRepository: CigaretteRepository

    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        scope.launch {
            cigaretteRepository.smoke(Smoke(1, ZonedDateTime.now()))
                .onCompletion {
                    binding.testStringTextView.text = testString
                }.collect {  }
        }
    }
}
