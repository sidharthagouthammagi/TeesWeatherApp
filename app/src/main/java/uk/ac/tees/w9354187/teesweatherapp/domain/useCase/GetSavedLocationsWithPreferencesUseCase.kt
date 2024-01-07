package uk.ac.tees.w9354187.teesweatherapp.domain.useCase

import uk.ac.tees.w9354187.teesweatherapp.domain.model.WeatherWithPreferences
import uk.ac.tees.w9354187.teesweatherapp.domain.repository.UserDataRepository
import uk.ac.tees.w9354187.teesweatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetSavedLocationsWithPreferencesUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val userDataRepository: UserDataRepository
) {
    operator fun invoke(): Flow<WeatherWithPreferences> {
        return combine(
            weatherRepository.savedLocations,
            userDataRepository.userData
        ) { savedLocations, userData ->
            WeatherWithPreferences(
                savedLocations = savedLocations,
                showCelsius = userData.showCelsius
            )
        }
    }
}