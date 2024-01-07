package uk.ac.tees.w9354187.teesweatherapp.presentation.screens.manageLocation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ManageLocationRoute(
    onBackClick: () -> Unit,
    onAddLocationClick: () -> Unit,
    onLocationClick: (String) -> Unit,
    onNavigateToAddLocationScreen: () -> Unit,
    viewModel: ManageLocationViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val selectedLocations by viewModel.selectedLocations.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.hasLocations.collect {
            if (!it) {
                onNavigateToAddLocationScreen()
            }
        }
    }

    ManageLocationScreen(
        uiState = uiState,
        selectedLocations = selectedLocations,
        onBackClick = onBackClick,
        onLocationCheck = { viewModel.selectLocation(it) },
        onAddLocationClick = onAddLocationClick,
        onLocationClick = onLocationClick,
        onDeleteLocation = { viewModel.deleteLocation() },
        onLogoutClick = {viewModel.signOut()},
        onErrorShown = { viewModel.errorShown() }
    )
}