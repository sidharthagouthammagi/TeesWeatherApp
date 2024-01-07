package uk.ac.tees.w9354187.teesweatherapp.data.local.model

import androidx.room.Embedded
import androidx.room.Relation
import uk.ac.tees.w9354187.teesweatherapp.data.local.entity.CurrentWeatherEntity
import uk.ac.tees.w9354187.teesweatherapp.data.local.entity.WeatherForecastEntity
import uk.ac.tees.w9354187.teesweatherapp.data.local.entity.WeatherLocationEntity

data class WeatherModel(
    @Embedded val weatherLocation: WeatherLocationEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "locationId"
    )
    val currentWeather: CurrentWeatherEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "locationId"
    )
    val weatherForecast: List<WeatherForecastEntity>
)
