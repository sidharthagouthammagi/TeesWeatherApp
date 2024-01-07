package uk.ac.tees.w9354187.teesweatherapp.splash

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import uk.ac.tees.w9354187.teesweatherapp.data.database.getUserFromFireStoreDB
import uk.ac.tees.w9354187.teesweatherapp.data.model.AppUser
import uk.ac.tees.w9354187.teesweatherapp.navigation.WeatherScreens
import uk.ac.tees.w9354187.teesweatherapp.session.SessionProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashViewModel : ViewModel() {

    fun redirect(navController: NavHostController) {
        if(Firebase.auth.currentUser == null){
            navController.navigate(WeatherScreens.LoginScreen.name)
            return
        }

        getUserFromFireStoreDB(
Firebase.auth.currentUser?.uid ?:""
        ){task ->
          if(!task.isSuccessful){
              navController.navigate(WeatherScreens.LoginScreen.name)
          }
            val user = task.result.toObject(AppUser::class.java)
            SessionProvider.user = user
            navController.navigate(WeatherScreens.HomeScreen.name)
        }
    }
}