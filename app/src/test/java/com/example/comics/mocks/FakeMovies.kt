package com.example.comics.mocks

import com.example.comics.home.data.dto.DataMoviesResponseDTO
import com.example.comics.home.data.dto.MoviesResponseDTO

val mockedDataMoviesResponseDTO = DataMoviesResponseDTO(
    results = listOf(
        MoviesResponseDTO(
            backdropPath = "https://image.tmdb.org/t/p/original/iZLqwEwUViJdSkGVjePGhxYzbDb.jpg",
            title = "War of the Worlds",
            overview = "Will Radford is a top cyber-security analyst for Homeland Security who tracks potential threats to national security through a mass surveillance program, until one day an attack by an unknown entity leads him to question whether the government is hiding something from him... and from the rest of the world.",
            posterPath = "https://image.tmdb.org/t/p/original/iZLqwEwUViJdSkGVjePGhxYzbDb.jpg",
            voteAverage = 4.587
        )
    )
)
