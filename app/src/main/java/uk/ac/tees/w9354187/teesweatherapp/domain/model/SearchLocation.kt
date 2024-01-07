package uk.ac.tees.w9354187.teesweatherapp.domain.model

data class SearchLocation(
    val name: String,
    val region: String,
    val country: String,
    val url: String
)