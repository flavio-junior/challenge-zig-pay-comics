package com.example.comics.home.data.repository

import TheMovieDBRepository
import com.example.comics.home.data.datasource.TheMovieDBDataSource
import com.example.comics.home.data.dto.DataMoviesResponseDTO
import com.example.comics.network.resources.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow

class TheMovieDBRepositoryImpl(
    private val theMovieDBDataSource: TheMovieDBDataSource
) : TheMovieDBRepository {

    override fun getTrendingMovies(): Flow<ObserveNetworkStateHandler<DataMoviesResponseDTO>> {
        return theMovieDBDataSource.getTrendingMovies()
    }
}
