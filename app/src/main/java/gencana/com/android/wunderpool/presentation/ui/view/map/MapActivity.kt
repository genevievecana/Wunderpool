package gencana.com.android.wunderpool.presentation.ui.view.map

import android.location.Location
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import gencana.com.android.wunderpool.R
import com.google.android.gms.maps.SupportMapFragment
import android.os.Bundle
import com.google.android.gms.maps.model.Marker
import gencana.com.android.wunderpool.domain.model.Car
import gencana.com.android.wunderpool.presentation.base.BaseActivity
import gencana.com.android.wunderpool.presentation.extensions.toast
import gencana.com.android.wunderpool.presentation.extensions.visibleInvisible
import gencana.com.android.wunderpool.presentation.utils.GetLocationHelper
import gencana.com.android.wunderpool.presentation.utils.generateMarkers
import kotlinx.android.synthetic.main.activity_map.*
import kotlin.collections.ArrayList


/**
 * Created by Gen Cana on 23/09/2018
 */
class MapActivity : BaseActivity<MapViewModel, List<Car>>(), OnMapReadyCallback, GetLocationHelper.LocationListener {

    override val layout: Int
        get() = R.layout.activity_map

    private var mMap: GoogleMap? = null

    private val markerList = ArrayList<Marker?>()

    private var locationHelper: GetLocationHelper? = null

    private var currentLocation: LatLng? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(this)
        locationHelper = GetLocationHelper(this, this)
    }

    private fun setUpMap() {
        mMap?.setOnMarkerClickListener{selectedMarker ->
            if (!selectedMarker.title.isNullOrEmpty()){
                markerList.map { it?.isVisible = selectedMarker.hashCode() == it?.hashCode() }
            }
            false
        }
        mMap?.setOnInfoWindowClickListener{
            it.hideInfoWindow()
            showMarkers()
        }

        mMap?.setOnInfoWindowCloseListener {
            showMarkers()
        }

    }

    override fun onLocationSuccess(location: Location) {
        markerList.addAll(generateMarkers(mMap,
                listOf(Car(coordinates = arrayOf(location.longitude, location.latitude, 0.0)))))
        moveCamera(location.latitude, location.longitude)
    }

    override fun onLocationFailed() {
        onError(getString(R.string.error_location))
    }

    override fun onLocationPermissionDenied() {
        onError(getString(R.string.error_location))
    }

    private fun showMarkers(){
        markerList.map { it?.isVisible = true }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
        setUpMap()

    }

    override fun showLoading(show: Boolean) {
        progress_bar.visibleInvisible(show)
    }

    override fun onResponseSuccess(data: List<Car>) {
        markerList.clear()
        markerList.addAll(generateMarkers(mMap, data))
        if (currentLocation == null){
            val coordinates = data.first().coordinates
            moveCamera(coordinates!![1], lng = coordinates[0])
        }
    }

    private fun moveCamera(lat: Double, lng: Double){
        currentLocation = LatLng(lat, lng)
        mMap?.moveCamera(CameraUpdateFactory.newLatLng(currentLocation))
    }

    override fun onError(errorMsg: String?) {
        toast(errorMsg ?: getString(R.string.error_default))
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        locationHelper?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}