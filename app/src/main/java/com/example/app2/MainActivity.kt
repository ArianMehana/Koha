package com.example.app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    lateinit var TodayView: TextView
    lateinit var TomorrowView: TextView
    lateinit var Weather: ImageView
    lateinit var Condition: TextView
    lateinit var Temperature: TextView
    lateinit var MaxTemperature: TextView
    lateinit var MinTemperature: TextView
    lateinit var Humidity: TextView
    lateinit var Precipitation: TextView
    lateinit var Wind: TextView

    val todayWeatherData = WeatherData(0, 25, 32, 10, 8, 25, 15)
    val tomorrowWeatherData = WeatherData(1, 15, 20, 5, 8, 25, 15)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TodayView = findViewById(R.id.today)
        TomorrowView = findViewById(R.id.tomorrow)
        Weather = findViewById(R.id.weather)
        Temperature = findViewById(R.id.temperature)
        Condition = findViewById(R.id.sunny)
        MaxTemperature = findViewById(R.id.maxtemp)
        MinTemperature = findViewById(R.id.mintemp)
        Humidity = findViewById(R.id.humidity)
        Wind = findViewById(R.id.wind)
        Precipitation = findViewById(R.id.precipitation)

        TodayView.setOnClickListener {
            showWeather(todayWeatherData)
        }

        TomorrowView.setOnClickListener {
            showWeather(tomorrowWeatherData)
        }

    }

    private fun showWeather(weatherData: WeatherData) {
        Wind.text = getText(R.string.wind_speed)
        Humidity.text = ("${weatherData.humidity} %")
        Temperature.text = weatherData.Temp.toString()
        MaxTemperature.text = weatherData.tempMax.toString()
        MinTemperature.text = weatherData.tempMin.toString()
        Precipitation.text = weatherData.precipitation.toString()

        when (weatherData.Condition) {
            0 ->
                Weather.setImageResource(R.drawable.ic_image_partlycloudy)


            1 ->
                Weather.setImageResource(R.drawable.ic_image_cloudy)

            else -> println("Error panic")
        }

    }

}


