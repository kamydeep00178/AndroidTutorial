package org.example.kotlin.databinding

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fragment.R
import com.fragment.databinding.ActivityMainWeatherBinding


class MainActivity : AppCompatActivity() {

    val weather = WeatherData(
            "Saint Petersburg",
            "10 °C",
            "Cloudy with rain and possible thunderstorms",
            "http://loremflickr.com/800/600/city",true)

    var counter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainWeatherBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_weather)

        binding.data = weather
    }

    fun changeTemperatureAndImage(view: View) {
        ++counter
        weather.temperature = "$counter °C"
        weather.imageUrl = "http://loremflickr.com/800/600/city?random=$counter"
        weather.notifyChange()
    }

    /*fun startActivity(view: View) = startActivity<OtherActivity>()*/
}