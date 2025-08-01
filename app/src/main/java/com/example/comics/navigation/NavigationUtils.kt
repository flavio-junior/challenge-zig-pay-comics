package com.example.comics.navigation

import kotlinx.serialization.json.Json

internal inline fun <reified T> T.toJson(): String = Json.encodeToString(value = this)
internal inline fun <reified T> String.fromJson(): T = Json.decodeFromString<T>(string = this)
