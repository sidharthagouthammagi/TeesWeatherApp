package uk.ac.tees.w9354187.teesweatherapp.data.repository

import uk.ac.tees.w9354187.teesweatherapp.data.local.dao.WeatherDao
import uk.ac.tees.w9354187.teesweatherapp.data.local.entity.WeatherForecastEntity
import uk.ac.tees.w9354187.teesweatherapp.data.mapper.toEntity
import uk.ac.tees.w9354187.teesweatherapp.data.mapper.toExternalModel
import uk.ac.tees.w9354187.teesweatherapp.data.mapper.toUpdatedEntity
import uk.ac.tees.w9354187.teesweatherapp.data.remote.WeatherApi
import uk.ac.tees.w9354187.teesweatherapp.domain.model.SavedLocation
import uk.ac.tees.w9354187.teesweatherapp.domain.model.SearchLocation
import uk.ac.tees.w9354187.teesweatherapp.domain.model.Weather
import uk.ac.tees.w9354187.teesweatherapp.domain.repository.WeatherRepository
import uk.ac.tees.w9354187.teesweatherapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val weatherDao: WeatherDao,
) : WeatherRepository {

    override val weather: Flow<List<Weather>> = weatherDao.getWeather()
        .map {
            it.map { weatherModel ->
                weatherModel.toExternalModel()
            }
        }

    override val savedLocations: Flow<List<SavedLocation>> = weatherDao.getSavedLocations()
        .map {
            it.map { savedLocationModel ->
                savedLocationModel.toExternalModel()
            }
        }

    override val isLocationTableNotEmpty = weatherDao.checkTableNotEmpty().distinctUntilChanged()

    override suspend fun getSearchLocations(searchQuery: String): Resource<List<SearchLocation>> {
        return try {
            val result = weatherApi.searchLocation(searchQuery)
                .map {
                    it.toExternalModel()
                }
            Resource.Success(result)
        } catch (e: Exception) {
            Resource.Error(e.message)
        }
    }

    override suspend fun addWeather(locationUrl: String): Resource<Unit> {
        return if (!weatherDao.checkWeatherExist(locationUrl)) {
            try {
                val response = weatherApi.getWeatherForecast(locationUrl)
                val location = response.location.toEntity(locationUrl)
                val currentEpochTime = location.localtimeEpoch
                val currentWeather = response.current.toEntity(locationUrl)
                val weatherForecast = response.forecast.forecastDay
                    .map {
                        it.toEntity(locationUrl, currentEpochTime)
                    }

                weatherDao.upsertWeather(location, currentWeather, weatherForecast)
                Resource.Success(Unit)
            } catch (e: Exception) {
                Resource.Error(e.message)
            }
        } else {
            Resource.Error("Location Already Exists")
        }
    }

    override suspend fun updateWeather(): Resource<Unit> {
        val weatherLocations = weatherDao.getLocationIds()

        return try {
            weatherLocations.forEach { locationId ->
                val response = weatherApi.getWeatherForecast(locationId)
                val location = response.location.toEntity(locationId)
                val currentEpochTime = location.localtimeEpoch
                val currentWeather = response.current.toUpdatedEntity(
                    locationId,
                    id = weatherDao.getCurrentWeatherId(locationId)
                )
                val weatherForecast = response.forecast.forecastDay

                var index = 0
                val weatherIds = weatherDao.getWeatherForecastIds(locationId)
                val updatedForecast = mutableListOf<WeatherForecastEntity>()
                weatherForecast.forEach {
                    val forecast = it.toUpdatedEntity(
                        locationId,
                        id = weatherIds[index],
                        currentEpochTime = currentEpochTime
                    )
                    updatedForecast.add(forecast)
                    index++
                }

                weatherDao.upsertWeather(location, currentWeather, updatedForecast)
            }
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message)
        }
    }

    override suspend fun deleteWeather(locationId: String) {
        weatherDao.deleteWeatherLocation(locationId)
    }
}