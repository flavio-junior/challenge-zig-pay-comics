package com.example.comics.home.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DataMoviesResponseDTO(
    val results: List<MoviesResponseDTO>? = null
)
