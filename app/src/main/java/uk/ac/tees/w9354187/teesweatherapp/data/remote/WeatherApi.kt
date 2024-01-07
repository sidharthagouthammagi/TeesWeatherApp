package uk.ac.tees.w9354187.teesweatherapp.data.remote

import uk.ac.tees.w9354187.teesweatherapp.BuildConfig
import uk.ac.tees.w9354187.teesweatherapp.data.remote.model.NetworkSearchLocation
import uk.ac.tees.w9354187.teesweatherapp.data.remote.model.NetworkWeatherResponse
import uk.ac.tees.w9354187.teesweatherapp.util.Constants.Companion.FORECAST_DAYS
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("/v1/search.json")
    suspend fun searchLocation(
        @Query("q")
        q: String,
        @Query("key")
        key: String = BuildConfig.API_KEY
    ): List<NetworkSearchLocation>

    @GET("/v1/forecast.json")
    suspend fun getWeatherForecast(
        @Query("q")
        q: String,
        @Query("days")
        days: Int = FORECAST_DAYS,
        @Query("key")
        key: String = BuildConfig.API_KEY
    ): NetworkWeatherResponse
}