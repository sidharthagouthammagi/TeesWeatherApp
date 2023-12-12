package uk.ac.tees.w9354187.teesweatherapp.di

import uk.ac.tees.w9354187.teesweatherapp.data.location.LocationTrackerImpl
import uk.ac.tees.w9354187.teesweatherapp.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {
    @Binds
    abstract fun bindLocationTracker(
        locationTrackerImpl: LocationTrackerImpl
    ): LocationTracker
}