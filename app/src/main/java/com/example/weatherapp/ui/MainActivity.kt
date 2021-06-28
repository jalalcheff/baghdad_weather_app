package com.example.weatherapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.data.CurrentDate
import com.example.weatherapp.data.DataManager
import com.example.weatherapp.data.GetMyLocationCity
import com.example.weatherapp.data.domain.WeatherStatus
import com.example.weatherapp.databinding.ActivityMainBinding
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var calendar: Calendar
     val client= OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }
    private fun init()
    {

        retriveData()
        android.os.SystemClock.sleep(10000)
        setLocationData()
    }

    private fun setLocationData() {
        val myPosition=  GetMyLocationCity(this)
        Log.v("result",myPosition.cityName.toString())
        binding.apply {
            captialName.text=myPosition.cityName.toString()
            heatDgree.text=DataManager.showResult().dataseries[0].temp2m.toString()
            weatherName.text=DataManager.showResult().dataseries[0].weather
            precipationValue.text=DataManager.showResult().dataseries[0].prec_amount.toString()
            humadityValue.text=DataManager.showResult().dataseries[0].rh2m
            windSpeedValue.text=DataManager.showResult().dataseries[0].wind10m.speed.toString()
            windDirectionValue.text=DataManager.showResult().dataseries[0].wind10m.direction
            cloudImage.setImageResource(DataManager.setWeatherImage(DataManager.showResult().dataseries[0].weather))
            date.text=CurrentDate.getCurrentDate()
        }

    }




    private fun retriveData() {

        val request=Request.Builder().url("http://www.7timer.info/bin/api.pl?lon=44.4&lat=33.3&product=civil&output=json").build()
        val response=client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("fail","${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string().let { jasonString->
                    val result =Gson().fromJson(jasonString,WeatherStatus::class.java)
                    DataManager.addWeatherStatus(result)

                }



            }

        })

    }

}