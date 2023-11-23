package uk.ac.tees.w9354187.teesweatherapp.data.model

import uk.ac.tees.w9354187.teesweatherapp.R

data class Category(
    val id: Int,
    val title: String,
    val imageResId: Int
) {
    companion object {
        fun getCategories(): List<Category> {
            return listOf(
                Category(
                    1, "Sports", R.drawable.sports
                ),
                Category(
                    2, "Music", R.drawable.music
                ), Category(
                    3, "Movies", R.drawable.movies
                )
            )
        }

        fun getCategoryImageByCategoryId(catId : Int) : Int {
          return  when(catId){
              1 -> R.drawable.sports
              2 -> R.drawable.music
              3 -> R.drawable.movies
              else -> R.drawable.sports
          }
        }

    }
}