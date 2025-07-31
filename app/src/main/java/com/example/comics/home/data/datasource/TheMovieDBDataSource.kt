package com.example.comics.home.data.datasource

import com.example.comics.home.data.dto.DataMoviesResponseDTO
import com.example.comics.network.resources.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow

interface TheMovieDBDataSource {
    fun getTrendingMovies(): Flow<ObserveNetworkStateHandler<DataMoviesResponseDTO>>
}
