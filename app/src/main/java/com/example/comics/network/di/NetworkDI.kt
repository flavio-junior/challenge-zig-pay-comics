package com.example.comics.network.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import org.koin.dsl.module

val networkModule = module {
    single { provideHttpClientConfig() }
    single { HttpClient(engineFactory = CIO, block = get()) }
}
