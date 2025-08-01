package com.example.comics.home.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import com.example.comics.R
import com.example.comics.components.FontSize
import com.example.comics.components.SpaceSize
import com.example.comics.components.onClickable
import com.example.comics.home.data.vo.MoviesResponseVO
import com.example.comics.home.utils.HomeUtils

@Composable
fun DetailsScreen(
    moviesResponseVO: MoviesResponseVO? = null,
    goToPreviousScreen: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = "${HomeUtils.PATH_IMAGE}${moviesResponseVO?.backdropPath}",
            contentDescription = null,
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = SpaceSize.spaceSize12),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(all = SpaceSize.spaceSize16)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .onClickable(onClick = goToPreviousScreen)
                    .testTag(tag = "onClick")
                    .size(size = SpaceSize.spaceSize36)
            )
            Text(
                text = moviesResponseVO?.title.toString(),
                color = Color.White,
                fontSize = FontSize.fontSize24,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .testTag(tag = "title")
                    .weight(weight = 0.1f)
            )
        }
        Text(
            text = moviesResponseVO?.overview.orEmpty(),
            color = Color.White,
            fontSize = FontSize.fontSize20,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(alignment = Alignment.BottomStart)
                .testTag(tag = "overview")
                .padding(all = SpaceSize.spaceSize24),
            textAlign = TextAlign.Justify
        )
    }
}
