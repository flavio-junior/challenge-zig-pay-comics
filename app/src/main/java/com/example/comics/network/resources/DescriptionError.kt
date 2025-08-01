package com.example.comics.network.resources

data class DescriptionError(
    val code: Int? = null,
    val type: ErrorType = ErrorType.CLIENT,
    val message: String? = null
)
