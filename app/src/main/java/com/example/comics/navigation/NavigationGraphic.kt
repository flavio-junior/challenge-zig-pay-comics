package com.example.comics.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.comics.components.ErrorScreen
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
                    navController.navigate(route = it)
                },
                goToErrorScreen = {
                    navController.navigate(route = AppDestinations.ErrorScreen)
                }
            )
        }

        composable<AppDestinations.DetailsScreen> { backStackEntry ->
            val route: AppDestinations.DetailsScreen =
                backStackEntry.toRoute<AppDestinations.DetailsScreen>()
            DetailsScreen(
                moviesResponseVO = route.movies.fromJson(),
                goToPreviousScreen = {
                    navController.popBackStack()
                }
            )
        }

        composable<AppDestinations.ErrorScreen> {
            ErrorScreen(
                tryAgain = {
                    navController.popBackStack()
                }
            )
        }
    }
}
