package gencana.com.android.wunderpool.presentation.utils

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import gencana.com.android.wunderpool.R
import gencana.com.android.wunderpool.domain.model.Car

/**
 * Created by Gen Cana on 25/09/2018
 */

private val icons = arrayOf(
        R.drawable.ic_map_car_1,
        R.drawable.ic_map_car_2,
        R.drawable.ic_map_car_3,
        R.drawable.ic_map_car_4,
        R.drawable.ic_map_car_5,
        R.drawable.ic_map_car_6,
        R.drawable.ic_map_car_7,
        R.drawable.ic_map_car_8,
        R.drawable.ic_map_car_9,
        R.drawable.ic_map_car_10
)

fun generateMarkers(map: GoogleMap?, carList: List<Car>): List<Marker?>{
    val markerList = ArrayList<Marker?>()
    val iconSize = icons.size
    for (i in 0..carList.lastIndex){
        val car = carList[i]
        val markerOptions = MarkerOptions()
                .position(LatLng(car.coordinates!![1], car.coordinates!![0]))
                .title(car.vin)
                .snippet(car.address)
                .icon(BitmapDescriptorFactory.fromResource(icons[i%iconSize]))
        markerList.add(map?.addMarker(markerOptions))
    }
    return markerList
}