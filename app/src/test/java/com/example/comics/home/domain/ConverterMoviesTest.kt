package com.example.comics.home.domain

import com.example.comics.home.data.vo.DataMoviesResponseVO
import com.example.comics.mocks.mockedDataMoviesResponseDTO
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class ConverterMoviesTest {

    private val converterMovies = ConverterMovies()
    private var expectedValue = DataMoviesResponseVO()

    @Before
    fun getActualValue() {
        expectedValue = converterMovies.converterMovies(result = mockedDataMoviesResponseDTO)
    }

    @Test
    fun whenCallConverterGivenDataReturnsMoviesResponseDTOVerifyReturnIfValid() {
        val actualValue: DataMoviesResponseVO =
            converterMovies.converterMovies(result = mockedDataMoviesResponseDTO)
        assertEquals(expected = expectedValue, actual = actualValue)
    }
}
