package uk.ac.tees.w9354187.teesweatherapp.data.remote.model

import uk.ac.tees.w9354187.teesweatherapp.domain.model.WeatherCondition
import com.squareup.moshi.Json

data class NetworkCurrentWeather(
    val condition: WeatherCondition,

    @field:Json(name = "feelslike_c")
    val feelsLikeC: Double,

    @field:Json(name = "feelslike_f")
    val feelsLikeF: Double,

    val humidity: Int,

    @field:Json(name = "is_day")
    val isDay: Int,

    @field:Json(name = "temp_c")
    val tempC: Double,

    @field:Json(name = "temp_f")
    val tempF: Double,

    val uv: Double,

    @field:Json(name = "vis_km")
    val visKm: Double,

    @field:Json(name = "vis_miles")
    val visMiles: Double,

    @field:Json(name = "wind_dir")
    val windDir: String,

    @field:Json(name = "wind_kph")
    val windKph: Double,

    @field:Json(name = "wind_mph")
    val windMph: Double
)