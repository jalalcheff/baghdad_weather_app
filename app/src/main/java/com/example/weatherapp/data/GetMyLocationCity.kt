package com.example.weatherapp.data

import android.content.Context
import android.location.Address
import android.location.Geocoder
import com.example.weatherapp.ui.MainActivity
import java.util.*

class GetMyLocationCity(var context: Context) {
    val geocoder = Geocoder(context, Locale.getDefault())
    val addresses: MutableList<Address>? = geocoder.getFromLocation( 33.3,44.4, 1)
    val cityName: String? = addresses?.get(0)?.getAddressLine(0)
}
