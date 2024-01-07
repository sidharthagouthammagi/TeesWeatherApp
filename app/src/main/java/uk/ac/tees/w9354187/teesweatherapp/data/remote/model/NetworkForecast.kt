package uk.ac.tees.w9354187.teesweatherapp.data.remote.model

import com.squareup.moshi.Json


data class NetworkForecast(
    @field:Json(name = "forecastday")
    val forecastDay: List<NetworkForecastDay>
)
