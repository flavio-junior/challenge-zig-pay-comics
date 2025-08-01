package com.example.comics.home.ui.view

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.comics.mocks.mockMovie
import org.junit.Rule
import org.junit.Test

class DetailsScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenCallScreenDetailsVerifyContentOfScreenIsValid() {
        composeTestRule.setContent {
            DetailsScreen(
                moviesResponseVO = mockMovie,
                goToPreviousScreen = {}
            )
        }

        composeTestRule.onNodeWithTag(testTag = "onClick", useUnmergedTree = true)
            .assertExists()
            .performClick()

        composeTestRule.onNodeWithTag(testTag = "title", useUnmergedTree = true)
            .assertExists()
            .assertTextContains(value = mockMovie.title.orEmpty())

        composeTestRule.onNodeWithTag(testTag = "overview", useUnmergedTree = true)
            .assertExists()
            .assertTextContains(value = mockMovie.overview.orEmpty())

        composeTestRule.onNodeWithText(text = mockMovie.title.toString())
            .assertExists()

        composeTestRule.onNodeWithText(text = mockMovie.overview.toString())
            .assertExists()
    }
}
