package uk.ac.tees.w9354187.teesweatherapp.domain.connectivity

import kotlinx.coroutines.flow.Flow

interface NetworkConnectionObserver {
    val networkStatus: Flow<NetworkStatus>
}