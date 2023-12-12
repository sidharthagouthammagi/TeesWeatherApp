package uk.ac.tees.w9354187.teesweatherapp.domain.model

data class WeatherLocation(
    val id: String,
    val country: String,
    val timezoneId: String,
    val localtimeEpoch: Int,
    val name: String,
    val region: String,
)
