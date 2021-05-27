package com.tech.myMap

import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fragment.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import java.io.IOException
import java.util.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var mMapsController: MapsController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
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



        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)

            val markerOptions = MarkerOptions().position(sydney).title(
                "Current Location"
            ).draggable(true)
            mMap.addMarker(markerOptions)


          //  mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
            mMap.getUiSettings().setZoomControlsEnabled(true);



       /* mMap.setOnMapClickListener(object : GoogleMap.OnMapClickListener {
            override fun onMapClick(p0: LatLng?) {
                if (markerOptions == null) {
                    mMarker = mMap.addMarker(MarkerOptions().position(p0))
                } else {
                    mMarker.setPosition(p0)
                }
            }*/



            /*  mMapsController = MapsController(this, mMap)
              mMapsController.setCustomMarker()*/
          /*  zoomButton.setOnClickListener {
                mMapsController.animateCamera()
            }*/
            mMap.setOnMarkerDragListener(object : OnMarkerDragListener {
                override fun onMarkerDragStart(p0: Marker?) {
                    Log.e("TAG", "onMarkerDragStart: " + p0.toString())
                }

                override fun onMarkerDrag(p0: Marker?) {
                    Log.e("TAG", "onMarkerDrag: " + p0.toString())
                }

                override fun onMarkerDragEnd(p0: Marker?) {
                    val latLng: LatLng? = p0?.getPosition()
                    val geocoder = Geocoder(this@MapsActivity, Locale.getDefault())
                    try {
                        val address =
                            latLng?.latitude?.let {
                                geocoder.getFromLocation(
                                    it,
                                    latLng?.longitude,
                                    1
                                )
                            }
                                ?.get(0)

                        Log.e("TAG", "onMarkerDragEnd: " + address)

                    } catch (e: IOException) {
                        e.printStackTrace()
                        Log.e("TAG", "onMarkerDragEnd: " + e.toString())
                    }
                }

            })
    }

}