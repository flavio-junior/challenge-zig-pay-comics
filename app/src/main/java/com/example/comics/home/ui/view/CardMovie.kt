package com.example.comics.home.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.comics.R
import com.example.comics.components.FontSize
import com.example.comics.components.SpaceSize
import com.example.comics.components.onClickable
import com.example.comics.home.data.vo.MoviesResponseVO
import com.example.comics.home.utils.HomeUtils

@Composable
fun CardMovie(
    moviesResponseVO: MoviesResponseVO,
    onClick: (MoviesResponseVO) -> Unit = {}
) {
    Box(
        modifier = Modifier.onClickable(onClick = { onClick(moviesResponseVO) })
    ) {
        AsyncImage(
            model = "${HomeUtils.PATH_IMAGE}${moviesResponseVO.backdropPath}",
            contentDescription = null,
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .fillMaxWidth()
                .height(height = SpaceSize.spaceSize300),
            contentScale = ContentScale.Crop
        )
        Text(
            text = moviesResponseVO.title.orEmpty(),
            color = Color.White,
            fontSize = FontSize.fontSize24,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(all = SpaceSize.spaceSize8)
                .testTag(tag = "title")
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = SpaceSize.spaceSize4),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(alignment = Alignment.TopEnd)
                .padding(all = SpaceSize.spaceSize8)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(size = SpaceSize.spaceSize36)
            )
            Text(
                text = moviesResponseVO.voteAverage.toString(),
                color = Color.White,
                fontSize = FontSize.fontSize24,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.testTag(tag = "voteAverage")
            )
        }
        Text(
            text = moviesResponseVO.overview.orEmpty(),
            color = Color.White,
            fontSize = FontSize.fontSize20,
            fontWeight = FontWeight.Bold,
            maxLines = 2,
            modifier = Modifier
                .align(alignment = Alignment.BottomStart)
                .padding(all = SpaceSize.spaceSize8)
                .testTag(tag = "overview"),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
@Preview(device = Devices.NEXUS_10, apiLevel = 35, showBackground = true, showSystemUi = true)
private fun CardMovieScreenPreview() {
    CardMovie(
        moviesResponseVO = MoviesResponseVO(
            backdropPath = "https://image.tmdb.org/t/p/original/iZLqwEwUViJdSkGVjePGhxYzbDb.jpg",
            title = "War of the Worlds",
            overview = "Will Radford is a top cyber-security analyst for Homeland Security who tracks potential threats to national security through a mass surveillance program, until one day an attack by an unknown entity leads him to question whether the government is hiding something from him... and from the rest of the world.",
            posterPath = "https://image.tmdb.org/t/p/original/iZLqwEwUViJdSkGVjePGhxYzbDb.jpg",
            voteAverage = 4.587
        )
    )
}
