package com.example.weatherapp.ui

import com.google.gson.annotations.SerializedName

class NationalResponse(
    val name:String,
    @SerializedName("country")val country: List<Country>
)