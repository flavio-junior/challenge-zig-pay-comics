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
                fontWeight = FontWeight.ExtraBold
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
                .padding(all = SpaceSize.spaceSize8),
            textAlign = TextAlign.Justify
        )
    }
}
