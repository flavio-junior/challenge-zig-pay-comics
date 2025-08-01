package com.example.comics.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.comics.mocks.mockMovie
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertTrue

class NavigationGraphicKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun settingsDefaultNavigationGraphic() {
        composeTestRule.setContent {
            navController = TestNavHostController(context = LocalContext.current)
            navController.navigatorProvider.addNavigator(navigator = ComposeNavigator())
            NavigationGraphic(navController = navController)
        }
    }

    @Test
    fun verifyCurrentRouteNavigationIsEqualsHomeScreenIsValid() {
        assertTrue { navController.currentBackStackEntry?.destination?.hasRoute<AppDestinations.HomeScreen>() == true }
    }


    @Test
    fun verifyCurrentRouteNavigationIsEqualsDetailsScreenIsValid() {
        composeTestRule.runOnIdle {
            val mockMovieJson = AppDestinations.DetailsScreen(mockMovie.toJson())
            navController.navigate(route = mockMovieJson)
        }
        assertTrue { navController.currentBackStackEntry?.destination?.hasRoute<AppDestinations.DetailsScreen>() == true }
    }


    @Test
    fun verifyCurrentRouteNavigationIsEqualsErrorScreenIsValid() {
        composeTestRule.runOnIdle {
            navController.navigate(route = AppDestinations.ErrorScreen)

            assertTrue { navController.currentBackStackEntry?.destination?.hasRoute<AppDestinations.ErrorScreen>() == true }
        }
    }
}
