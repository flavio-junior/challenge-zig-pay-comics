package com.example.comics.home.domain

import com.example.comics.home.data.dto.DataMoviesResponseDTO
import com.example.comics.home.data.dto.MoviesResponseDTO
import com.example.comics.home.data.vo.DataMoviesResponseVO
import com.example.comics.home.data.vo.MoviesResponseVO

class ConverterMovies {

    fun converterMovies(
        result: DataMoviesResponseDTO? = null
    ): DataMoviesResponseVO {
        val content: MutableList<MoviesResponseVO> = mutableListOf(MoviesResponseVO())
        result?.results?.map {
            content.add(element = converterMovieResponseDTO(moviesResponseDTO = it))
        }
        return DataMoviesResponseVO(results = content)
    }

    private fun converterMovieResponseDTO(
        moviesResponseDTO: MoviesResponseDTO? = null
    ): MoviesResponseVO {
        return MoviesResponseVO(
            backdropPath = moviesResponseDTO?.backdropPath,
            title = moviesResponseDTO?.title,
            overview = moviesResponseDTO?.overview,
            posterPath = moviesResponseDTO?.posterPath
        )
    }
}