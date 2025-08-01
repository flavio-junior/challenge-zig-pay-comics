package com.example.comics.home.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comics.components.CircleLoader
import com.example.comics.components.SpaceSize
import com.example.comics.home.data.vo.DataMoviesResponseVO
import com.example.comics.home.ui.viewmodel.ComicsViewModel
import com.example.comics.navigation.AppDestinations
import com.example.comics.navigation.toJson
import com.example.comics.network.resources.UiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    goToDetailsScreen: (AppDestinations.DetailsScreen) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        val viewModel: ComicsViewModel = koinViewModel()
        val response: UiState<DataMoviesResponseVO> by viewModel.getTrendingMovies.collectAsStateWithLifecycle()
        when (response) {
            is UiState.Init -> Unit

            is UiState.Loading -> {
                CircleLoader(
                    modifier = Modifier.size(size = SpaceSize.spaceSize100),
                    isVisible = true
                )
            }

            is UiState.OnSuccess -> {
                (response as UiState.OnSuccess<DataMoviesResponseVO>).response.results?.map {
                    if (it.title != null) {
                        CardMovie(
                            moviesResponseVO = it,
                            onClick = {
                                goToDetailsScreen(AppDestinations.DetailsScreen(movies = it.toJson()))
                            }
                        )
                    }
                }
            }

            is UiState.Error -> {
                Text(text = "Error", color = Color.Black)
            }
        }
    }
}
