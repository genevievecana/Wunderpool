package gencana.com.android.wunderpool.presentation.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import gencana.com.android.wunderpool.domain.model.Car
import gencana.com.android.wunderpool.presentation.model.PlaceMarks

/**
 * Created by Gen Cana on 23/09/2018
 */
private const val JSON_FILE = "locations.json"

fun getCarListFromJson(context: Context): List<Car>{
    var jsonReader: JsonReader? = null

    val inputStream = context.assets.open(JSON_FILE)
    jsonReader = JsonReader(inputStream.reader())
    val data: PlaceMarks = Gson().fromJson(jsonReader, PlaceMarks::class.java)
    jsonReader.close()

    return data.carList
}