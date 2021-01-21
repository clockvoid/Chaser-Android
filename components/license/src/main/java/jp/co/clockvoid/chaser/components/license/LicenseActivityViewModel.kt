package jp.co.clockvoid.chaser.components.license

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

    private var holeLicenseList: List<PackageLicense>? = null

    private val _packageLicenseList = MutableStateFlow<List<PackageLicense>>(emptyList())
    val packageLicenseList: StateFlow<List<PackageLicense>> = _packageLicenseList

    val filterQuery: MutableStateFlow<String> = MutableStateFlow("")

    init {

        viewModelScope.launch {
            filterQuery.collect { query ->
                _packageLicenseList.value = holeLicenseList?.filter { license ->
                    val regex = Regex(query.toLowerCase())
                    val project = license.project.toLowerCase() ?: ""
                    val description = license.description?.toLowerCase() ?: ""
                    regex.containsMatchIn(project) or regex.containsMatchIn(description)
                } ?: emptyList()
            }
        }
    }

    private suspend fun readLicensesJson(): String {

        return withContext(Dispatchers.IO) {
            val path = context.getString(R.string.assets_license_json_path)
            val bufferedReader = context.assets.open(path).bufferedReader()

            bufferedReader.use {
                it.readText()
            }
        }
    }

    fun getPackageLicenseList() {

        viewModelScope.launch {
            val json = readLicensesJson()
            holeLicenseList = Json.decodeFromString(json)
            _packageLicenseList.value = holeLicenseList!!
        }
    }
}
