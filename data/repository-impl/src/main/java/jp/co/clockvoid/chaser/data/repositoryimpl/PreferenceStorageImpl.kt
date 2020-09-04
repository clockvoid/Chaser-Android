package jp.co.clockvoid.chaser.data.repositoryimpl

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.WorkerThread
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import jp.co.clockvoid.chaser.data.repository.PreferenceStorage
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PreferenceStorageImpl @Inject constructor(
    @ApplicationContext context: Context
) : PreferenceStorage {
    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override var isAlcoholVisible by BooleanPreference(prefs, PREF_IS_ALCOHOL_VISIBLE, true)
    override var isCaffeineVisible by BooleanPreference(prefs, PREF_IS_CAFFEINE_VISIBLE, true)
    override var isCigaretteVisible by BooleanPreference(prefs, PREF_IS_CIGARETTE_VISIBLE, true)

    companion object {
        private const val PREFS_NAME = "jp.co.clockvoid.chaser_preferences"
        private const val PREF_IS_ALCOHOL_VISIBLE = "is_alcohol_visible"
        private const val PREF_IS_CAFFEINE_VISIBLE = "is_caffeine_visible"
        private const val PREF_IS_CIGARETTE_VISIBLE = "is_cigarette_visible"
    }
}

private class IntPreference(
    private val prefs: SharedPreferences,
    private val name: String,
    private val defaultValue: Int
) : ReadWriteProperty<Any, Int> {

    @WorkerThread
    override fun getValue(thisRef: Any, property: KProperty<*>): Int {
        return prefs.getInt(name, defaultValue)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
        prefs.edit { putInt(name, value) }
    }
}

private class BooleanPreference(
    private val prefs: SharedPreferences,
    private val name: String,
    private val defaultValue: Boolean
) : ReadWriteProperty<Any, Boolean> {

    @WorkerThread
    override fun getValue(thisRef: Any, property: KProperty<*>): Boolean {
        return prefs.getBoolean(name, defaultValue)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean) {
        prefs.edit { putBoolean(name, value) }
    }
}

private class StringPreference(
    private val prefs: SharedPreferences,
    private val name: String,
    private val defaultValue: String?
) : ReadWriteProperty<Any, String?> {

    @WorkerThread
    override fun getValue(thisRef: Any, property: KProperty<*>): String? {
        return prefs.getString(name, defaultValue)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String?) {
        prefs.edit { putString(name, value) }
    }
}
