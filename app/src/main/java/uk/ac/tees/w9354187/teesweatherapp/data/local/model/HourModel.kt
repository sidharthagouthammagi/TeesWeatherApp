package uk.ac.tees.w9354187.teesweatherapp.data.local.model

import uk.ac.tees.w9354187.teesweatherapp.domain.model.WeatherCondition

data class HourModel(
    val chanceOfRain: Int,
    val chanceOfSnow: Int,
    val condition: WeatherCondition,
    val isDay: Int,
    val tempC: Double,
    val tempF: Double,
    val time: String,
    val timeEpoch: Int
)