package com.example.comics.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.comics.home.ui.view.DetailsScreen
import com.example.comics.home.ui.view.HomeScreen

@Composable
fun NavigationGraphic(
    navController: NavHostController = rememberNavController(),
    startDestination: AppDestinations = AppDestinations.HomeScreen
) {
    NavHost(navController = navController, startDestination = startDestination) {

        composable<AppDestinations.HomeScreen> {
            HomeScreen(
                goToDetailsScreen = {
                    navController.navigate(route = AppDestinations.DetailsScreen)
                }
            )
        }

        composable<AppDestinations.DetailsScreen> {
            DetailsScreen(
                goToPreviousScreen = {
                    navController.popBackStack()
                }
            )
        }
    }
}
