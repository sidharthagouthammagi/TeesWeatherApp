package uk.ac.tees.w9354187.teesweatherapp.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import uk.ac.tees.w9354187.teesweatherapp.domain.model.Astro
import uk.ac.tees.w9354187.teesweatherapp.domain.model.Day
import uk.ac.tees.w9354187.teesweatherapp.data.local.model.HourModel

@Entity(
    tableName = "weather_forecast",
    indices = [Index(value = arrayOf("locationId"))],
    foreignKeys = [ForeignKey(
        entity = WeatherLocationEntity::class,
        parentColumns = ["id"],
        childColumns = ["locationId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class WeatherForecastEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val locationId: String,
    val dateEpoch: Int,
    val astro: Astro,
    @Embedded val day: Day,
    val hour: List<HourModel>
)
