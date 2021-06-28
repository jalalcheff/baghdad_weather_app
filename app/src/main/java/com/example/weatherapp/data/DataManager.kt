package com.example.weatherapp.data

import com.example.weatherapp.R
import com.example.weatherapp.data.domain.WeatherStatus

object DataManager {
    private val weatherStatusList = mutableListOf<WeatherStatus>()
    fun addWeatherStatus(weather: WeatherStatus) {
        weatherStatusList.add(weather)
    }

    fun showResult(): WeatherStatus {
        return weatherStatusList[0]
    }

    fun showListSize(): Int {
        return weatherStatusList.size
    }

    fun WeathersName(cloudCover: Int): String {
        if (cloudCover <= 2)
            return "Clear"
        else if (cloudCover<=5)
            return "Partly Cloudy"
        else if (cloudCover<=7)
            return "Cloudy"
        else
            return "Very Cloudy"

    }
    fun setWeatherImage(weather:String):Int{
        var weatherResource:String
             if (weather=="clearday")
            return R.drawable.clear
           else if (weather=="partlycloudy")
           return R.drawable.partilly_cloudy
            else if (weather=="cloudy")
            return R.drawable.partilly_cloudy
            else if (weather=="rain")
            return R.drawable.rain
            else if (weather=="snow")
            return R.drawable.snow
            else if (weather=="thunderstorm")
            return R.drawable.thunder_storm
        else
            return R.drawable.thunder_storm_with_rain
        }


    fun printListItems()
    {

//        Log.i("bbbbbb", weatherStatusList[0].dataseries[0].weather)
    }

}