package uk.ac.tees.w9354187.teesweatherapp.domain.repository

import uk.ac.tees.w9354187.teesweatherapp.domain.model.SavedLocation
import uk.ac.tees.w9354187.teesweatherapp.domain.model.SearchLocation
import uk.ac.tees.w9354187.teesweatherapp.domain.model.Weather
import uk.ac.tees.w9354187.teesweatherapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    val weather: Flow<List<Weather>>

    val savedLocations: Flow<List<SavedLocation>>

    val isLocationTableNotEmpty: Flow<Boolean>

    suspend fun getSearchLocations(searchQuery: String): Resource<List<SearchLocation>>

    suspend fun addWeather(locationUrl: String): Resource<Unit>

    suspend fun updateWeather(): Resource<Unit>

    suspend fun deleteWeather(locationId: String)
}