package com.example.comics.home.data.datasource

import com.example.comics.home.data.api.TheMovieDBApiService
import com.example.comics.home.data.dto.DataMoviesResponseDTO
import com.example.comics.network.resources.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow

class TheMovieDBDataSourceImpl(
    private val theMovieDBApiService: TheMovieDBApiService
) : TheMovieDBDataSource {


    override fun getTrendingMovies(): Flow<ObserveNetworkStateHandler<DataMoviesResponseDTO>> {
      return  theMovieDBApiService.getTrendingMovies()
    }
}
