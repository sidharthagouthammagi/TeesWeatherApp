package uk.ac.tees.w9354187.teesweatherapp.data.mapper

import uk.ac.tees.w9354187.teesweatherapp.data.local.model.SavedLocationModel
import uk.ac.tees.w9354187.teesweatherapp.domain.model.SavedLocation
import uk.ac.tees.w9354187.teesweatherapp.domain.model.WeatherType

fun SavedLocationModel.toExternalModel() = SavedLocation(
    id = id,
    country = country,
    name = name,
    region = region,
    weatherType = WeatherType.fromWeatherCondition(code),
    isDay = isDay,
    tempC = tempC,
    tempF = tempF,
    maxTempC = maxTempC,
    maxTempF = maxTempF,
    minTempC = minTempC,
    minTempF = minTempF
)