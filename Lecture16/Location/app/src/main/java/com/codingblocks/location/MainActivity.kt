package com.codingblocks.location

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.simpleName

    private val RQ_CALL = 12345
    private val RQ_CONTACT = 12346
    private val RQ_LOCATION = 12347


    private val locationProvider: FusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnCall.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) == PackageManager.PERMISSION_DENIED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    RQ_CALL
                )
            }
        }

        btnContacts.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.WRITE_CONTACTS
                ) == PackageManager.PERMISSION_DENIED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.WRITE_CONTACTS),
                    RQ_CONTACT
                )
            }
        }

        btnLocation.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_DENIED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    RQ_LOCATION
                )
            }
        }

    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        when (requestCode) {

            RQ_LOCATION -> {

                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    locationProvider.lastLocation
                        .addOnCanceledListener {
                            Toast.makeText(this, "Unable to fetch location, please retry", Toast.LENGTH_SHORT).show()
                        }
                        .addOnSuccessListener {
                            it?.let {
                                Log.e(TAG, "Latitude is ${it.latitude}")
                                Log.e(TAG, "Longitude is ${it.longitude}")
                                Log.e(TAG, "Accuracy is ${it.accuracy}")
                                Log.e(TAG, "Altitude is ${it.altitude}")
                                Log.e(TAG, "Speed is ${it.speed}")
                                Log.e(TAG, "Time in milliseconds is ${it.time}")
                                Log.e(TAG, "Location provider is ${it.provider}")
                            }
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "Failed to fetch location, please retry", Toast.LENGTH_SHORT).show()
                            it.printStackTrace()
                        }
                        .addOnCompleteListener {
                            Toast.makeText(this, "Location listener completed", Toast.LENGTH_SHORT).show()
                        }
                } else
                    Toast.makeText(this, "Please Grant the Location Permission!", Toast.LENGTH_SHORT).show()
            }

            RQ_CONTACT -> {

                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Launch an intent to add a contact
                } else
                    Toast.makeText(this, "Please Grant the Contact Permission!", Toast.LENGTH_SHORT).show()
            }

            RQ_CALL -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Launch an intent to add a contact
                } else
                    Toast.makeText(this, "Please Grant the Calling Permission!", Toast.LENGTH_SHORT).show()
            }
            else -> Toast.makeText(this, "Wrong choice!", Toast.LENGTH_SHORT).show()
        }

    }

}
