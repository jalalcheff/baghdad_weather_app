package com.example.weatherapp.data

import java.text.SimpleDateFormat
import java.util.*

object CurrentDate {
    fun getCurrentDate()=SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
}