package com.example.comics.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.comics.R

@Composable
fun ErrorScreen(
    tryAgain: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.brightness_alert),
            contentDescription = null,
            modifier = Modifier.size(size = SpaceSize.spaceSize100)
        )
        Text(
            text = stringResource(id = R.string.internal_error_system),
            color = Color.Black,
            fontSize = FontSize.fontSize24,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(all = SpaceSize.spaceSize8)
        )
        Button(
            onClick = {
                tryAgain()
            }
        ) {
            Text(text = stringResource(id = R.string.try_again))
        }
    }
}

@Composable
@Preview(device = Devices.NEXUS_10, apiLevel = 35, showBackground = true, showSystemUi = true)
private fun ErrorScreenPreview() {
    ErrorScreen()
}
