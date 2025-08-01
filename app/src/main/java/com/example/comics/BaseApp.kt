package com.example.comics

import android.app.Application
import com.example.comics.home.di.homeModule
import com.example.comics.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApp() : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(androidContext = this@BaseApp)
            androidLogger(level = Level.INFO)
            modules(modules = listOf(networkModule, homeModule))
        }
    }
}