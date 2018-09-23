package gencana.com.android.wunderpool.presentation.model

import com.google.gson.annotations.SerializedName
import gencana.com.android.wunderpool.domain.model.Car

/**
 * Created by Gen Cana on 23/09/2018
 */
data class PlaceMarks(@SerializedName("placemarks") val carList: List<Car>)