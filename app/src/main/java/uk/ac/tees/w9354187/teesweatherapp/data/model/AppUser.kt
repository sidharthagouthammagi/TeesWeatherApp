package uk.ac.tees.w9354187.teesweatherapp.data.model

data class AppUser(
    val id: String? = null,
    val firstName: String? = null,
    val email: String? = null
) {
    companion object {
        const val COLLECTION_NAME = "Users"
    }
}
