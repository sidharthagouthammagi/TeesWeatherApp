package uk.ac.tees.w9354187.teesweatherapp.screens.register

import AlertDialog
import Button
import LoadingDialog
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uk.ac.tees.w9354187.teesweatherapp.R
import uk.ac.tees.w9354187.teesweatherapp.components.WeatherAppBar
import uk.ac.tees.w9354187.teesweatherapp.components.TextField
import uk.ac.tees.w9354187.teesweatherapp.navigation.WeatherScreens


@Composable
fun RegisterScreen(navController: NavHostController, viewModel: RegisterViewModel) {
    RegisterContent(viewModel = viewModel, navController = navController)
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterContent(viewModel: RegisterViewModel, navController: NavHostController) {

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
       WeatherAppBar(topAppTitle = "Create An Account")
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.fillMaxHeight(0.4F))
            TextField(
                state = viewModel.firstNameState,
                label = "First name",
                errorState = viewModel.firstNameError
            )
            TextField(
                state = viewModel.emailState,
                label = "Email",
                errorState = viewModel.emailError
            )
            TextField(
                state = viewModel.passwordState,
                label = "Password",
                errorState = viewModel.passwordError,
                isPassword = true
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            TextButton(onClick = {
                navController.navigate(WeatherScreens.LoginScreen.name)
            }) {
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Already have an Account?", style = TextStyle(
                        fontSize = 16.sp, color = colorResource(
                            id = R.color.black
                        )
                    )
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 16.dp))

            Button(buttonText = "Register") {
                viewModel.sendAuthDataToFirebase()
            }
            if (viewModel.showLoading.value) LoadingDialog()
            if (viewModel.message.value.isNotEmpty() && viewModel.showDialog.value) AlertDialog(
                alertMessage = {
                    Text(text = viewModel.message.value, textAlign = TextAlign.Center, style = TextStyle(
                        fontSize = 18.sp,
                       color = Color.DarkGray,
                    )
                    )
                },
                onDismissRequest = {
                    viewModel.showDialog.value = false

                },
                dismissButton = {
                    TextButton(onClick = {
                        viewModel.showDialog.value = false
                    }) { Text(text = "Cancel") }
                }
            ) {
                TextButton(onClick = {
                    if(viewModel.message.value == "Successful Registration")
                        navController.navigate(WeatherScreens.HomeScreen.name)
                    viewModel.showDialog.value = false
                }) { Text(text = "OK") }
            }
        }
    }
}


