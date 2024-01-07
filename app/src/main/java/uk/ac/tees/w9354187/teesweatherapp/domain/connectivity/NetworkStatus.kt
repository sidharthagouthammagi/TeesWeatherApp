package uk.ac.tees.w9354187.teesweatherapp.domain.connectivity

sealed class NetworkStatus {
    object Available: NetworkStatus()
    object Unavailable: NetworkStatus()
}