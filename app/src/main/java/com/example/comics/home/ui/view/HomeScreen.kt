package com.example.comics.home.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.comics.home.ui.viewmodel.ComicsViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen(
    goToDetailsScreen: () -> Unit = {}
) {
    val viewModel: ComicsViewModel = koinViewModel()
    LaunchedEffect(Unit) {
        viewModel.getTrendingMovies()
    }
}
