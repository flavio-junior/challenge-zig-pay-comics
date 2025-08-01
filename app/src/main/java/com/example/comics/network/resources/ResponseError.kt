package com.example.comics.network.resources

import kotlinx.serialization.Serializable

@Serializable
data class ResponseError(
    val status: Int,
    val message: String
)
