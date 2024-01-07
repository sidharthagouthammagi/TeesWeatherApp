package uk.ac.tees.w9354187.teesweatherapp.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import uk.ac.tees.w9354187.teesweatherapp.domain.model.WeatherCondition

@Entity(
    tableName = "current_weather",
    indices = [Index(value = arrayOf("locationId"))],
    foreignKeys = [ForeignKey(
        entity = WeatherLocationEntity::class,
        parentColumns = ["id"],
        childColumns = ["locationId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class CurrentWeatherEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val locationId: String,
    @Embedded val condition: WeatherCondition,
    val feelsLikeC: Double,
    val feelsLikeF: Double,
    val humidity: Int,
    val isDay: Int,
    val tempC: Double,
    val tempF: Double,
    val uv: Double,
    val visKm: Double,
    val visMiles: Double,
    val windDir: String,
    val windKph: Double,
    val windMph: Double
)
