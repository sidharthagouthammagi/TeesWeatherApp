package uk.ac.tees.w9354187.teesweatherapp.data.mapper

import uk.ac.tees.w9354187.teesweatherapp.data.remote.model.NetworkSearchLocation
import uk.ac.tees.w9354187.teesweatherapp.domain.model.SearchLocation

fun NetworkSearchLocation.toExternalModel() = SearchLocation(
    name = name,
    region = region,
    country = country,
    url = url
)