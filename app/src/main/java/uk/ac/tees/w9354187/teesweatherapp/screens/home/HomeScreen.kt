package uk.ac.tees.w9354187.teesweatherapp.screens.home

import WeatherCard
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import uk.ac.tees.w9354187.teesweatherapp.R
import uk.ac.tees.w9354187.teesweatherapp.components.WeatherAppBar
import uk.ac.tees.w9354187.teesweatherapp.navigation.WeatherScreens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel, navController: NavHostController) {
    Scaffold(
        topBar = {
            WeatherAppBar(topAppTitle = "Home", actions = {
                IconButton(onClick = {
                    viewModel.singOutFromFirebase()
                    navController.popBackStack()
                    navController.navigate(WeatherScreens.LoginScreen.name)
                }) {
                    Icon(tint = Color.White,
                        modifier = Modifier.size(32.dp),
                        painter = painterResource(id = R.drawable.ic_logout),
                        contentDescription = "logout"
                    )
                }
            })
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = colorResource(id = R.color.blue),
                contentColor = Color.White,
                onClick = { navController.navigate(WeatherScreens.AddRoomScreen.name) }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_fba_btn),
                    contentDescription = ""
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding()) // lazem el tarteb
        ) {
            LazyVerticalStaggeredGrid(
                modifier = Modifier.fillMaxSize(),
                columns = StaggeredGridCells.Fixed(2),
                contentPadding = PaddingValues(24.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalItemSpacing = 24.dp
            ) {
                items(viewModel.roomList.value.size) { itemPosition ->
                    val room = viewModel.roomList.value[itemPosition]
                    WeatherCard(item = room, position = itemPosition) {
                        navController.currentBackStackEntry?.savedStateHandle?.apply {
                            set("room", room)
                        }
                        navController.navigate(WeatherScreens.ChatRoomScreen.name )

                    }

                }
            }
        }
    }
}


