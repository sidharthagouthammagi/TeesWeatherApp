package uk.ac.tees.w9354187.teesweatherapp.data.mapper

import uk.ac.tees.w9354187.teesweatherapp.domain.model.Astro
import uk.ac.tees.w9354187.teesweatherapp.domain.model.Day
import uk.ac.tees.w9354187.teesweatherapp.data.local.model.HourModel
import uk.ac.tees.w9354187.teesweatherapp.data.local.entity.CurrentWeatherEntity
import uk.ac.tees.w9354187.teesweatherapp.data.local.entity.WeatherForecastEntity
import uk.ac.tees.w9354187.teesweatherapp.data.local.entity.WeatherLocationEntity
import uk.ac.tees.w9354187.teesweatherapp.data.remote.model.NetworkAstro
import uk.ac.tees.w9354187.teesweatherapp.data.remote.model.NetworkCurrentWeather
import uk.ac.tees.w9354187.teesweatherapp.data.remote.model.NetworkDay
import uk.ac.tees.w9354187.teesweatherapp.data.remote.model.NetworkForecastDay
import uk.ac.tees.w9354187.teesweatherapp.data.remote.model.NetworkHour
import uk.ac.tees.w9354187.teesweatherapp.data.remote.model.NetworkWeatherLocation
import uk.ac.tees.w9354187.teesweatherapp.domain.model.Hour
import uk.ac.tees.w9354187.teesweatherapp.domain.model.WeatherType

fun NetworkWeatherLocation.toEntity(locationUrl: String) = WeatherLocationEntity(
    id = locationUrl,
    country = country,
    timezoneId = timezoneId,
    localtimeEpoch = localtimeEpoch,
    name = name,
    region = region
)

fun NetworkCurrentWeather.toEntity(locationId: String) = CurrentWeatherEntity(
    locationId = locationId,
    condition = condition,
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

fun NetworkCurrentWeather.toUpdatedEntity(locationId: String, id: Long) = CurrentWeatherEntity(
    id = id,
    locationId = locationId,
    condition = condition,
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

fun NetworkForecastDay.toEntity(locationId: String, currentEpochTime: Int) = WeatherForecastEntity(
    locationId = locationId,
    dateEpoch = dateEpoch,
    astro = astro.toExternalModel(),
    day = day.toExternalModel(),
    hour = hour
        .filter { it.timeEpoch >= currentEpochTime }
        .map { it.toModel() }
)

fun NetworkForecastDay.toUpdatedEntity(locationId: String, id: Long, currentEpochTime: Int) = WeatherForecastEntity(
    id = id,
    locationId = locationId,
    dateEpoch = dateEpoch,
    astro = astro.toExternalModel(),
    day = day.toExternalModel(),
    hour = hour
        .filter { it.timeEpoch >= currentEpochTime }
        .map { it.toModel() }
)

fun NetworkAstro.toExternalModel() = Astro(
    sunrise = sunrise,
    sunset = sunset
)

fun NetworkDay.toExternalModel() = Day(
    dailyChanceOfRain = dailyChanceOfRain,
    dailyChanceOfSnow = dailyChanceOfSnow,
    maxTempC = maxTempC,
    maxTempF = maxTempF,
    minTempC = minTempC,
    minTempF = minTempF,
)

fun NetworkHour.toModel() = HourModel(
    chanceOfRain = chanceOfRain,
    chanceOfSnow = chanceOfSnow,
    condition = condition,
    isDay = isDay,
    tempC = tempC,
    tempF = tempF,
    time = time,
    timeEpoch = timeEpoch
)

fun HourModel.toExternalModel() = Hour(
    chanceOfRain = chanceOfRain,
    chanceOfSnow = chanceOfSnow,
    weatherType = WeatherType.fromWeatherCondition(condition.code),
    isDay = isDay,
    tempC = tempC,
    tempF = tempF,
    time = time,
    timeEpoch = timeEpoch
)