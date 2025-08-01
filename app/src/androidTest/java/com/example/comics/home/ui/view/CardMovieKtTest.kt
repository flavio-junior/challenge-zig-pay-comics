package com.example.comics.home.ui.view

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.example.comics.mocks.mockMovie
import org.junit.Rule
import org.junit.Test

class CardMovieKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenTheApiReturnsSuccessfulVerifyContentOfCardIsValid() {
        composeTestRule.setContent {
            CardMovie(moviesResponseVO = mockMovie)
        }

        composeTestRule.onNodeWithTag(testTag = "title", useUnmergedTree = true)
            .assertExists()
            .assertTextContains(value = mockMovie.title.orEmpty())

        composeTestRule.onNodeWithTag(testTag = "overview", useUnmergedTree = true)
            .assertExists()
            .assertTextContains(value = mockMovie.overview.orEmpty())


        composeTestRule.onNodeWithTag(testTag = "voteAverage", useUnmergedTree = true)
            .assertExists()
            .assertTextContains(value = mockMovie.voteAverage.toString())


        composeTestRule.onNodeWithText(text = mockMovie.title.toString())
            .assertExists()

        composeTestRule.onNodeWithText(text = mockMovie.overview.toString())
            .assertExists()

        composeTestRule.onNodeWithText(text = mockMovie.voteAverage.toString())
            .assertExists()
    }
}
