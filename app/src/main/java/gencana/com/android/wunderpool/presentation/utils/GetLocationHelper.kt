package gencana.com.android.wunderpool.presentation.utils

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import android.support.v4.app.ActivityCompat
import com.google.android.gms.location.*

/**
 * Created by Gen Cana on 25/09/2018
 */
class GetLocationHelper(private var activity: Activity,
                     private var locationListener: LocationListener) {

    interface LocationListener{

        fun onLocationSuccess(location: Location)

        fun onLocationFailed()

        fun onLocationPermissionDenied()
    }

    private val REQUEST_LOCATION = 2

    private var locationClient: FusedLocationProviderClient? = null

    private var isSuccess: Boolean? = null

    private var locationRequest: LocationRequest

    private var locationCallback: LocationCallback

    init {
        locationRequest = LocationRequest.create()
        locationRequest.numUpdates = 1

        locationCallback = object: LocationCallback() {

            override fun onLocationResult(p0: LocationResult?) {
                super.onLocationResult(p0)
                if (p0?.lastLocation == null) {
                    isSuccess = false
                    locationListener.onLocationFailed()
                } else {
                    isSuccess = true
                    locationListener.onLocationSuccess(p0.lastLocation)
                }

            }

            override fun onLocationAvailability(p0: LocationAvailability?) {
                super.onLocationAvailability(p0)
                if (p0?.isLocationAvailable == null || !p0.isLocationAvailable) {
                    isSuccess = false
                    locationListener.onLocationFailed()
                }
            }
        }

        setupLocation()
    }


    fun setupLocation(){
        if (ActivityCompat.checkSelfPermission(activity,
                        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                            Manifest.permission.ACCESS_FINE_LOCATION)) {
                requestPermission()
            } else {
                requestPermission()
            }
        } else {
            addLocationListener()
        }

    }

    private fun requestPermission(){
        ActivityCompat.requestPermissions(activity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_LOCATION)
    }

    @SuppressLint("MissingPermission")
    private fun addLocationListener(){
        if (locationClient == null) {
            locationClient = LocationServices.getFusedLocationProviderClient(activity)

        }

        locationClient?.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
    }

    fun onRequestPermissionsResult(requestCode: Int,
                                   permissions: Array<out String>,
                                   grantResults: IntArray) {
        if (requestCode == REQUEST_LOCATION) {
            if (grantResults.isNotEmpty() && grantResults.first() == PackageManager.PERMISSION_GRANTED) {
                addLocationListener()
            } else {
                isSuccess = false
                locationListener.onLocationPermissionDenied()
            }
        }
    }

}