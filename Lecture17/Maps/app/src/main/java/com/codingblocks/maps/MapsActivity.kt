package com.codingblocks.maps

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var lastMarker: Marker

    private lateinit var lastPosition: LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

//        val map = supportFragmentManager.findFragmentByTag("test") as SupportMapFragment

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        with(mMap.uiSettings) {
            setAllGesturesEnabled(true)
            isZoomControlsEnabled = true
            isCompassEnabled = true
        }

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)

        lastPosition = sydney

        lastMarker = mMap.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney")
                .draggable(true)
        )

//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 5f))
//
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 3f))

        mMap.setOnMapClickListener {

            lastMarker.remove()

            lastMarker = mMap.addMarker(
                MarkerOptions()
                    .position(it)
                    .title("New Location")
                    .draggable(true)
            )

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(it, 3f))

        }

        mMap.setOnMarkerDragListener(object : GoogleMap.OnMarkerDragListener {

            override fun onMarkerDragEnd(marker: Marker) {

                Log.e("TAG", "Last marker : ${lastMarker.position.latitude} ${lastMarker.position.longitude}")
                Log.e("TAG", "Current marker : ${marker.position.latitude} ${marker.position.longitude}")
//
//                mMap.addPolyline(
//                    PolylineOptions()
//                        .add(lastPosition, marker.position)
//                        .color(ContextCompat.getColor(baseContext, R.color.colorPrimary))
//                        .width(2f)
//                        .zIndex(2f)
//                )

//                mMap.addPolygon(
//                    PolygonOptions()
//                        .add(sydney, lastPosition, marker.position)
//                        .fillColor(ContextCompat.getColor(baseContext, R.color.colorAccent))
//                        .strokeColor(ContextCompat.getColor(baseContext, R.color.colorPrimary))
//                        .strokeWidth(2f)
//                        .zIndex(2f)
//                )

                mMap.addCircle(
                    CircleOptions()
                        .radius(100.0)
                        .center(lastPosition)
                        .fillColor(ContextCompat.getColor(baseContext, R.color.colorAccent))
                        .strokeColor(ContextCompat.getColor(baseContext, R.color.colorPrimary))
                        .strokeWidth(2f)
                )

                lastPosition = marker.position

                lastMarker.remove()

                lastMarker = mMap.addMarker(
                    MarkerOptions()
                        .position(marker.position)
                        .title("New Location")
                        .draggable(true)
                )

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.position, 10f))
            }

            override fun onMarkerDragStart(marker: Marker) {

//                lastMarker = marker

                Log.e("TAG", "Start marker : ${marker.position.latitude} ${marker.position.longitude}")
            }

            override fun onMarkerDrag(marker: Marker) {

            }

        })

    }
}
