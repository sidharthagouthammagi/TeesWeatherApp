package uk.ac.tees.w9354187.teesweatherapp.domain.model

data class Day(
    val dailyChanceOfRain: Int,
    val dailyChanceOfSnow: Int,
    val maxTempC: Double,
    val maxTempF: Double,
    val minTempC: Double,
    val minTempF: Double,
)