package com.example.comics.network.di

import com.example.comics.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val networkModule = module {
    single {
        HttpClient {
            install(plugin = ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true })
            }
            install(plugin = Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
            install(plugin = DefaultRequest) {
                url {
                    protocol = io.ktor.http.URLProtocol.HTTP
                    host = BuildConfig.BASE_URL_APP
                }
                contentType(type = ContentType.Application.Json)
            }
            install(plugin = HttpTimeout) {
                requestTimeoutMillis = 600000L
                connectTimeoutMillis = 600000L
                socketTimeoutMillis = 600000L
            }
        }
    }
}
