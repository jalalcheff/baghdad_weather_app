package com.example.weatherapp.data.domain

data class Datasery(
    val cloudcover: Int,
    val lifted_index: Int,
    val prec_amount: Int,
    val prec_type: String,
    val rh2m: String,
    val temp2m: Int,
    val timepoint: Int,
    val weather: String,
    val wind10m: Wind10m
)