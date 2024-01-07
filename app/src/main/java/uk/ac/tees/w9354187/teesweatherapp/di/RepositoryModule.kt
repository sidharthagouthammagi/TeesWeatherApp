package uk.ac.tees.w9354187.teesweatherapp.di

import uk.ac.tees.w9354187.teesweatherapp.data.repository.UserDataRepositoryImpl
import uk.ac.tees.w9354187.teesweatherapp.data.repository.WeatherRepositoryImpl
import uk.ac.tees.w9354187.teesweatherapp.domain.repository.UserDataRepository
import uk.ac.tees.w9354187.teesweatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository

    @Binds
    abstract fun bindUserDataRepository(
        userDataRepositoryImpl: UserDataRepositoryImpl
    ): UserDataRepository
}