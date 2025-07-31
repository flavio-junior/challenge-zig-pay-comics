package com.example.comics.home.di

import TheMovieDBRepository
import com.example.comics.home.data.api.TheMovieDBApiService
import com.example.comics.home.data.api.TheMovieDBApiServiceImpl
import com.example.comics.home.data.datasource.TheMovieDBDataSource
import com.example.comics.home.data.datasource.TheMovieDBDataSourceImpl
import com.example.comics.home.data.repository.TheMovieDBRepositoryImpl
import com.example.comics.home.domain.ConverterMovies
import com.example.comics.home.ui.viewmodel.ComicsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    single<TheMovieDBApiService> {
        TheMovieDBApiServiceImpl(httpClient = get())
    }
    single<TheMovieDBDataSource> {
        TheMovieDBDataSourceImpl(theMovieDBApiService = get())
    }
    single<TheMovieDBRepository> {
        TheMovieDBRepositoryImpl(theMovieDBDataSource = get())
    }
    single {
        ConverterMovies()
    }
    viewModelOf(::ComicsViewModel)
}
