package uk.ac.tees.w9354187.teesweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import uk.ac.tees.w9354187.teesweatherapp.navigation.TeesWeatherNavigation
import uk.ac.tees.w9354187.teesweatherapp.ui.theme.JetChatAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeesWeatherApp()
        }
    }
}

@Composable
fun TeesWeatherApp() {
    JetChatAppComposeTheme {
        TeesWeatherNavigation()
    }
}