package gencana.com.android.wunderpool.data.db

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by Gen Cana on 22/09/2018
 */
class ColumnConverter {

    @TypeConverter
    fun fromString(value: String): Array<Double> {
        val listType = object : TypeToken<Array<Double>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: Array<Double>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}