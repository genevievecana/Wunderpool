package gencana.com.android.wunderpool.presentation.ui.view.map

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
import gencana.com.android.wunderpool.presentation.utils.generateMarkers
import kotlinx.android.synthetic.main.activity_map.*
import kotlin.collections.ArrayList


/**
 * Created by Gen Cana on 23/09/2018
 */
class MapActivity : BaseActivity<MapViewModel, List<Car>>(), OnMapReadyCallback {

    override val layout: Int
        get() = R.layout.activity_map

    private var mMap: GoogleMap? = null

    private val markerList = ArrayList<Marker?>()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment).getMapAsync(this)
    }

    private fun setUpMap() {
        mMap?.setOnMarkerClickListener{selectedMarker ->
            markerList.map { it?.isVisible = selectedMarker.hashCode() == it?.hashCode() }
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
        if (data.isNotEmpty()){
            mMap?.moveCamera(CameraUpdateFactory.newLatLng(
                    LatLng(data.first().coordinates!![1], data.first().coordinates!![0])))

        }
        markerList.clear()
        markerList.addAll(generateMarkers(mMap, data))

    }

    override fun onError(errorMsg: String?) {
        toast(errorMsg ?: getString(R.string.error_default))
    }

}