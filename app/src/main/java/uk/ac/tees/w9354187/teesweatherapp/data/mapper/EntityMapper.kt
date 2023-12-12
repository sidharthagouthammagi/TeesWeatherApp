package uk.ac.tees.w9354187.teesweatherapp.data.mapper

import uk.ac.tees.w9354187.teesweatherapp.data.local.entity.CurrentWeatherEntity
import uk.ac.tees.w9354187.teesweatherapp.data.local.entity.WeatherForecastEntity
import uk.ac.tees.w9354187.teesweatherapp.data.local.entity.WeatherLocationEntity
import uk.ac.tees.w9354187.teesweatherapp.domain.model.CurrentWeather
import uk.ac.tees.w9354187.teesweatherapp.domain.model.WeatherForecast
import uk.ac.tees.w9354187.teesweatherapp.domain.model.WeatherLocation
import uk.ac.tees.w9354187.teesweatherapp.domain.model.WeatherType

fun CurrentWeatherEntity.toExternalModel() = CurrentWeather(
    locationId = locationId,
    weatherType = WeatherType.fromWeatherCondition(condition.code),
    feelsLikeC = feelsLikeC,
    feelsLikeF = feelsLikeF,
    humidity = humidity,
    isDay = isDay,
    tempC = tempC,
    tempF = tempF,
    uv = uv,
    visKm = visKm,
    visMiles = visMiles,
    windDir = windDir,
    windKph = windKph,
    windMph = windMph
)

fun WeatherForecastEntity.toExternalModel() = WeatherForecast(
    locationId = locationId,
    dateEpoch = dateEpoch,
    astro =  astro,
    day = day,
    hour = hour.map { it.toExternalModel() }
)

fun WeatherLocationEntity.toExternalModel() = WeatherLocation(
    id = id,
    country = country,
    timezoneId = timezoneId,
    localtimeEpoch = localtimeEpoch,
    name = name,
    region = region
)