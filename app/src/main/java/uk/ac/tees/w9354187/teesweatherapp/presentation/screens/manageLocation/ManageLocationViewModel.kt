package uk.ac.tees.w9354187.teesweatherapp.presentation.screens.manageLocation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import uk.ac.tees.w9354187.teesweatherapp.domain.model.WeatherWithPreferences
import uk.ac.tees.w9354187.teesweatherapp.domain.repository.WeatherRepository
import uk.ac.tees.w9354187.teesweatherapp.domain.useCase.GetSavedLocationsWithPreferencesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uk.ac.tees.w9354187.teesweatherapp.navigation.WeatherScreens
import javax.inject.Inject

@HiltViewModel
class ManageLocationViewModel @Inject constructor(
    private val getSavedLocationsWithPreferencesUseCase: GetSavedLocationsWithPreferencesUseCase,
    private val weatherRepository: WeatherRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ManageLocationUiState())
    val uiState = _uiState.asStateFlow()

    private val _selectedLocations = MutableStateFlow<Set<String>>(emptySet())
    val selectedLocations = _selectedLocations.asStateFlow()

    val hasLocations = weatherRepository.isLocationTableNotEmpty.shareIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        replay = 1
    )

    init {
        getSavedLocations()
    }

    private fun getSavedLocations() {
        viewModelScope.launch {
            getSavedLocationsWithPreferencesUseCase().collect { savedLocations ->
                _uiState.update { it.copy(locationWithPreferences = savedLocations) }
            }
        }
    }

    fun selectLocation(id: String) {
        val selected = _selectedLocations.value.toMutableSet()

        if(selected.contains(id)) {
            selected.remove(id)
        } else {
            selected.add(id)
        }
        _selectedLocations.update { selected.toSet() }
    }

    fun deleteLocation() {
        viewModelScope.launch {
            val selected = _selectedLocations.value.toMutableSet()
            if(selected.isEmpty()) {
                _uiState.update { it.copy(errorMessage = "Select atleast one location") }
            } else {
                val itemIterator = selected.iterator()
                while(itemIterator.hasNext()) {
                    val item = itemIterator.next()
                    weatherRepository.deleteWeather(item)
                    itemIterator.remove()
                }
            }
            _selectedLocations.update { selected }
        }
    }

    fun errorShown() {
        _uiState.update { it.copy(errorMessage = null) }
    }
    fun signOut(){
        FirebaseAuth.getInstance().signOut()
    }
}

data class ManageLocationUiState(
    val locationWithPreferences: WeatherWithPreferences = WeatherWithPreferences(),
    val errorMessage: String? = null
)