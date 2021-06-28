package com.example.weatherapp.data.domain

import com.example.weatherapp.data.domain.Datasery

data class WeatherStatus(
        val dataseries: List<Datasery>,
        val `init`: String,
        val product: String
)