package uk.ac.tees.w9354187.teesweatherapp.domain.model

data class SavedLocation(
    val id: String,
    val country: String,
    val name: String,
    val region: String,
    val weatherType: WeatherType,
    val isDay: Int,
    val tempC: Double,
    val tempF: Double,
    val maxTempC: Double,
    val maxTempF: Double,
    val minTempC: Double,
    val minTempF: Double
)
