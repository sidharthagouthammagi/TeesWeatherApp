package uk.ac.tees.w9354187.teesweatherapp.data.remote.model

import uk.ac.tees.w9354187.teesweatherapp.domain.model.WeatherCondition
import com.squareup.moshi.Json

data class NetworkHour(
    @field:Json(name = "chance_of_rain")
    val chanceOfRain: Int,

    @field:Json(name = "chance_of_snow")
    val chanceOfSnow: Int,

    val condition: WeatherCondition,

    @field:Json(name = "is_day")
    val isDay: Int,

    @field:Json(name = "temp_c")
    val tempC: Double,

    @field:Json(name = "temp_f")
    val tempF: Double,

    val time: String,

    @field:Json(name = "time_epoch")
    val timeEpoch: Int
)