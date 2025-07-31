package com.example.comics.home.data.api

import com.example.comics.BuildConfig
import com.example.comics.home.data.dto.DataMoviesResponseDTO
import com.example.comics.network.resources.ObserveNetworkStateHandler
import com.example.comics.network.resources.safeRunDispatcher
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.url
import io.ktor.http.HttpHeaders
import kotlinx.coroutines.flow.Flow

class TheMovieDBApiServiceImpl(
    private val httpClient: HttpClient
) : TheMovieDBApiService {

    override fun getTrendingMovies(): Flow<ObserveNetworkStateHandler<DataMoviesResponseDTO>> {
        return safeRunDispatcher {
            httpClient.get {
                url(urlString = "/3/trending/movie/day")
                headers {
                    append(
                        name = HttpHeaders.Authorization,
                        value = "Bearer ${BuildConfig.AUTHORIZATION}"
                    )
                }
            }
        }
    }
}
