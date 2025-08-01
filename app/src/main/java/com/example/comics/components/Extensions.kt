package com.example.comics.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role

fun Modifier.onClickable(
    onClick: () -> Unit = {}
): Modifier {
    return this.then(
        other = Modifier.clickable(
            interactionSource = MutableInteractionSource(),
            indication = null,
            enabled = true,
            onClick = onClick,
            role = Role.Button
        )
    )
}
