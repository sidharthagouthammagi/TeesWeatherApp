package uk.ac.tees.w9354187.teesweatherapp.domain.model

data class Weather(
    val weatherLocation: WeatherLocation,
    val currentWeather: CurrentWeather,
    val weatherForecast: List<WeatherForecast>
)
