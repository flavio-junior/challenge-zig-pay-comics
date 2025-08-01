package com.example.comics.home.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponseDTO(
    @SerialName(value = "backdrop_path")
    val backdropPath: String? = null,
    val title: String? = null,
    val overview: String? = null,
    @SerialName(value = "poster_path")
    val posterPath: String? = null,
    @SerialName(value = "vote_average")
    val voteAverage: Double? = 0.0
)
