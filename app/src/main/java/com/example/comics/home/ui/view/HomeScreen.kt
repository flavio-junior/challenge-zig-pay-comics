package com.example.comics.home.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.comics.home.data.vo.DataMoviesResponseVO
import com.example.comics.home.ui.viewmodel.ComicsViewModel
import com.example.comics.network.resources.UiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    goToDetailsScreen: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .background(color = Color.Red)
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        val viewModel: ComicsViewModel = koinViewModel()
        LaunchedEffect(Unit) {
            viewModel.getTrendingMovies()
        }
        val response: UiState<DataMoviesResponseVO> by viewModel.getTrendingMovies.collectAsStateWithLifecycle()
        when (response) {
            is UiState.Init -> Unit

            is UiState.Loading -> {
                CircularProgressIndicator()
            }

            is UiState.OnSuccess -> {
                (response as UiState.OnSuccess<DataMoviesResponseVO>).response.results?.map {
                    Text(text = it.title.orEmpty(), color = Color.Black)
                }
            }

            is UiState.Error -> {
            Text(text = "Error", color = Color.Black)
            }
        }
    }
}
