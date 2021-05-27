package com.tech.myMap

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.fragment.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsController(context: Context, googleMap: GoogleMap) {
    private val mTimeSquare = LatLng(40.758895, -73.985131)
    private val mContext: Context = context
    private val mGoogleMap: GoogleMap = googleMap
    fun setCustomMarker() {
      //  val blackMarkerIcon : BitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.ic_baseline_360_24)
        val markerOptions : MarkerOptions = MarkerOptions().position(mTimeSquare).title(
            mContext.getString(
                R.string.time_square
            )
        ).snippet(mContext.getString(R.string.i_am_snippet)).icon(bitmapDescriptorFromVector(mContext, R.drawable.ic_baseline_360_24))
        mGoogleMap.addMarker(markerOptions)
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(mTimeSquare))
    }
    fun animateCamera() {
        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mTimeSquare, 15f))
//    mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mTimeSquare, 15f))
    }
    private fun bitmapDescriptorFromVector(
        context: Context,
        @DrawableRes vectorDrawableResourceId: Int
    ): BitmapDescriptor? {
        val background = ContextCompat.getDrawable(context, R.drawable.ic_baseline_360_24)
        background!!.setBounds(0, 0, background.intrinsicWidth, background.intrinsicHeight)
        val vectorDrawable = ContextCompat.getDrawable(context, vectorDrawableResourceId)
        vectorDrawable!!.setBounds(
            40,
            20,
            vectorDrawable.intrinsicWidth + 40,
            vectorDrawable.intrinsicHeight + 20
        )
        val bitmap = Bitmap.createBitmap(
            background.intrinsicWidth,
            background.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        background.draw(canvas)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }
}