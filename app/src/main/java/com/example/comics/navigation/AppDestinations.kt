package com.example.comics.navigation

import kotlinx.serialization.Serializable

sealed interface AppDestinations {

    @Serializable
    data object HomeScreen : AppDestinations

    @Serializable
    data object DetailsScreen : AppDestinations
}
