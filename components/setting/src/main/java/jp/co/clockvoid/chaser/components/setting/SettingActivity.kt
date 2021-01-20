package jp.co.clockvoid.chaser.components.setting

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import jp.co.clockvoid.chaser.components.license.License
import jp.co.clockvoid.chaser.components.setting.databinding.ActivitySettingBinding

/**
 * SettingActivity
 * It's based on https://github.com/android/user-interface-samples/blob/master/PreferencesKotlin/app/src/main/java/com/example/androidx/preference/sample/MainActivity.kt
 */
class SettingActivity : AppCompatActivity() {

    private var _binding: ActivitySettingBinding? = null
    private val binding: ActivitySettingBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBar)
        binding.toolBar.setNavigationOnClickListener {
            finish()
        }

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        } else {
            title = savedInstanceState.getCharSequence(TITLE_TAG)
        }
        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount == 0) {
                setTitle(R.string.setting_title)
            }
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putCharSequence(TITLE_TAG, title)
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.chaser_preferences, rootKey)
            val visibleList: List<SwitchPreference?> = listOf(
                findPreference("is_alcohol_visible"),
                findPreference("is_caffeine_visible"),
                findPreference("is_cigarette_visible")

            )
            visibleList.map { item ->
                requireNotNull(item)
                item.setOnPreferenceChangeListener { _, newValue ->
                    visibleList.forEach { it!!.isEnabled = true }
                    val checked = visibleList.filter { it!!.isChecked && (newValue == false && it == item).not() }
                    if (checked.size == 1 && newValue == false) checked.last()!!.isEnabled = false
                    true
                }
            }
            findPreference<Preference>("license")?.setOnPreferenceClickListener {
                //OssLicensesMenuActivity.setActivityTitle(requireContext().getString(R.string.open_source_license))
                //val intent = Intent(requireActivity(), OssLicensesMenuActivity::class.java)
                //startActivity(intent)
                License.launch(requireContext())
                true
            }
        }
    }

    companion object {
        private const val TITLE_TAG = "settingActivityTitle"

        fun from(activity: Activity): Intent {
            return Intent(activity, SettingActivity::class.java)
        }
    }
}
