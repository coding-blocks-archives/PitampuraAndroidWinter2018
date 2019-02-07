package com.codingblocks.locationrequests

import android.annotation.SuppressLint
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    private val locationClient by lazy {
        LocationServices.getFusedLocationProviderClient(this)
    }

    private lateinit var locationCallback: LocationCallback

    private val locationRequest: LocationRequest by lazy {
        LocationRequest.create().apply {
            this.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
            this.interval = 1000
            this.fastestInterval = 500
        }
    }

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationCallback = object : LocationCallback() {

            override fun onLocationResult(locationResult: LocationResult?) {

                Toast.makeText(baseContext,"LocationResult Called", Toast.LENGTH_SHORT).show()

                locationResult?.let {

                    val lastKnownLocation = it.lastLocation

                    val location: Location = it.locations[0]
                    Log.e(TAG, "Latitude is ${location.latitude}")
                    Log.e(TAG, "Longitude is ${location.longitude}")
                    Log.e(TAG, "Accuracy is ${location.accuracy}")
                    Log.e(TAG, "Altitude is ${location.altitude}")
                    Log.e(TAG, "Speed is ${location.speed}")
                    Log.e(TAG, "Time in milliseconds is ${location.time}")
                    Log.e(TAG, "Location provider is ${location.provider}")

                    Toast.makeText(baseContext,"Location Shown", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onLocationAvailability(locationAvailability: LocationAvailability?) {
                locationAvailability?.let {
                    if (it.isLocationAvailable)
                        Toast.makeText(baseContext, "Back online!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val locationSettingsRequest = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest)
            .build()


        val settingClient = LocationServices.getSettingsClient(this)

        settingClient.checkLocationSettings(locationSettingsRequest)
            .addOnSuccessListener {

                //Initialize a location request
                locationClient.requestLocationUpdates(locationRequest, locationCallback, null)

            }
            .addOnFailureListener {
                if (it is ResolvableApiException) {
                    it.startResolutionForResult(this, 12345)
                }
            }
    }
}
