package com.example.comics.home.ui.viewmodel

import TheMovieDBRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comics.home.data.vo.DataMoviesResponseVO
import com.example.comics.home.domain.ConverterMovies
import com.example.comics.home.ui.extra.ComicsViewModelImpl
import com.example.comics.network.resources.ObserveNetworkStateHandler
import com.example.comics.network.resources.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ComicsViewModel(
    private val theMovieDBRepository: TheMovieDBRepository,
    private val converterMovies: ConverterMovies
) : ViewModel(), ComicsViewModelImpl {

    private val _getTrendingMovies = MutableStateFlow<UiState<DataMoviesResponseVO>>(UiState.Init)
    val getTrendingMovies = _getTrendingMovies.asStateFlow()

    init {
        getTrendingMovies()
    }

    override fun getTrendingMovies() {
        viewModelScope.launch {
            theMovieDBRepository.getTrendingMovies().collect { response ->
                when (response) {
                    is ObserveNetworkStateHandler.Loading -> {
                        _getTrendingMovies.value = UiState.Loading
                    }

                    is ObserveNetworkStateHandler.Error -> {
                        _getTrendingMovies.value = UiState.Error(error = response.exception)
                    }

                    is ObserveNetworkStateHandler.Success -> {
                        val objectConverted: DataMoviesResponseVO =
                            converterMovies.converterMovies(result = response.result)
                        _getTrendingMovies.value =
                            UiState.OnSuccess(response = objectConverted)
                    }
                }
            }
        }
    }
}
