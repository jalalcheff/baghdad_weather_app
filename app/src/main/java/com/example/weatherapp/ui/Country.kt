package com.example.weatherapp.ui

import com.google.gson.annotations.SerializedName

class Country (
    @SerializedName("country_id")  val id: String,
    val probability: Double
    )