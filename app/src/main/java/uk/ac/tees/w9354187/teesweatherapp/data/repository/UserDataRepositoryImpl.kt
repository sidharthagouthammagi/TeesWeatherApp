package uk.ac.tees.w9354187.teesweatherapp.data.repository

import uk.ac.tees.w9354187.teesweatherapp.domain.model.UserData
import uk.ac.tees.w9354187.teesweatherapp.data.datastore.UserPreferencesDataSource
import uk.ac.tees.w9354187.teesweatherapp.domain.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userPreferencesDataSource: UserPreferencesDataSource
) : UserDataRepository {
    override val userData: Flow<UserData> = userPreferencesDataSource.userData

    override suspend fun setWeatherUnit(useCelsius: Boolean) =
        userPreferencesDataSource.setWeatherUnit(useCelsius)
}