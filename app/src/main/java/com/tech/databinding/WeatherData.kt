package org.example.kotlin.databinding

import androidx.databinding.BaseObservable


class WeatherData(
        var location: String,
        var temperature: String,
        var info: String,
        var imageUrl: String,
        var state : Boolean
) : BaseObservable()