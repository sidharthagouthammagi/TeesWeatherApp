package uk.ac.tees.w9354187.teesweatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.w9354187.teesweatherapp.screens.home.HomeScreen
import uk.ac.tees.w9354187.teesweatherapp.screens.home.HomeViewModel
import uk.ac.tees.w9354187.teesweatherapp.screens.login.LoginScreen
import uk.ac.tees.w9354187.teesweatherapp.screens.login.LoginViewModel
import uk.ac.tees.w9354187.teesweatherapp.screens.register.RegisterScreen
import uk.ac.tees.w9354187.teesweatherapp.screens.register.RegisterViewModel

@Composable
fun TeesWeatherNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = WeatherScreens.RegisterScreen.name) {

     /*   composable(route = ChatScreens.SplashScreen.name) {
            val viewModel: SplashViewModel = viewModel()
            SplashScreen(viewModel = viewModel, navController = navController)
        }
*/
        composable(route = WeatherScreens.RegisterScreen.name) {
            val viewModel: RegisterViewModel = viewModel()
            RegisterScreen(viewModel = viewModel, navController = navController)
        }

        composable(route = WeatherScreens.LoginScreen.name) {
            val viewModel: LoginViewModel = viewModel()
            LoginScreen(viewModel = viewModel, navController = navController)
        }

        composable(route = WeatherScreens.HomeScreen.name) {
            val viewModel: HomeViewModel = viewModel()
            HomeScreen(viewModel = viewModel, navController = navController)
        }


    }

}