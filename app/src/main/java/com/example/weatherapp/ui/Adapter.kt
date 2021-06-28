package com.example.weatherapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.data.DataManager
import com.example.weatherapp.data.domain.WeatherStatus
import com.example.weatherapp.databinding.WeatherItemBinding

class Adapter(val list: List<WeatherStatus>):RecyclerView.Adapter<Adapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.weather_item,parent,false)
        return WeatherViewHolder(view)
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val cureentCityWeather=list[position]
        holder.binding.apply {
            DataManager.printListItems()
        }
    }

    class WeatherViewHolder(viewItem: View):RecyclerView.ViewHolder(viewItem)
    {
        val binding=WeatherItemBinding.bind(viewItem)
    }

}
