package gencana.com.android.wunderpool.presentation.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by Gen Cana on 23/09/2018
 */

class SharedPref @Inject constructor(context: Context){

    private val PREFS_FILENAME = "prefs"
    private val KEY_CARS_ADDED = "cars_added"
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)


    var carDataAdded: Boolean?
        get() = prefs.getBoolean(KEY_CARS_ADDED, false)
        set(value) = prefs.edit().putBoolean(KEY_CARS_ADDED, value ?: false).apply()
}