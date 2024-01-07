package uk.ac.tees.w9354187.teesweatherapp.data.remote.model

data class NetworkWeatherResponse(
    val location: NetworkWeatherLocation,
    val current: NetworkCurrentWeather,
    val forecast: NetworkForecast
)