package uk.ac.tees.w9354187.teesweatherapp.data.mapper

import uk.ac.tees.w9354187.teesweatherapp.domain.model.Weather
import uk.ac.tees.w9354187.teesweatherapp.data.local.model.WeatherModel

fun WeatherModel.toExternalModel() = Weather(
    weatherLocation = weatherLocation.toExternalModel(),
    currentWeather = currentWeather.toExternalModel(),
    weatherForecast = weatherForecast.map { it.toExternalModel() }
)