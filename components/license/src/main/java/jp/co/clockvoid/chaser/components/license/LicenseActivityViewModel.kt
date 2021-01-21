package jp.co.clockvoid.chaser.components.license

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class PackageLicense(
    val project: String,
    val description: String?,
    val version: String?,
    val developers: List<String>,
    val url: String?,
    val year: String?,
    val licenses: List<OssLicense>,
    val dependency: String?
)

@Serializable
data class OssLicense(
    val license: String,
    val license_url: String
)

class LicenseActivityViewModel @ViewModelInject constructor(
    @ApplicationContext val context: Context
) : ViewModel() {

    private val _packageLicenseList = MutableStateFlow<List<PackageLicense>>(emptyList())
    val packageLicenseList: StateFlow<List<PackageLicense>> = _packageLicenseList

    private fun readLicensesJson(): String {

        val path = context.getString(R.string.assets_license_json_path)
        val bufferedReader = context.assets.open(path).bufferedReader()

        return bufferedReader.use {
            it.readText()
        }
    }

    fun getPackageLicenseList() {
        viewModelScope.launch {
            val json = readLicensesJson()
            _packageLicenseList.value = Json.decodeFromString(json)
        }
    }
}
