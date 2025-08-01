package com.example.comics.home.data.vo

import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponseVO(
    val backdropPath: String? = null,
    val title: String? = null,
    val overview: String? = null,
    val posterPath: String? = null,
    val voteAverage: Double? = 0.0
)
