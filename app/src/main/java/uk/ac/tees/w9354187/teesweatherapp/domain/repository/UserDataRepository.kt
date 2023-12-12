package uk.ac.tees.w9354187.teesweatherapp.domain.repository

import uk.ac.tees.w9354187.teesweatherapp.domain.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
    val userData: Flow<UserData>
    suspend fun setWeatherUnit(useCelsius: Boolean)
}