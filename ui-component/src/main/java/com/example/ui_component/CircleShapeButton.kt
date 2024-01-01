package com.example.ui_component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircleShapeButton(size: Dp, background: Color, @DrawableRes icon: Int, onAction: () -> Unit) {
    IconButton(
        modifier = Modifier
            .wrapContentSize()
            .clip(CircleShape)
            .background(background),
        onClick = onAction
    ) {
        Icon(
            modifier = Modifier
                .size(size)
                .padding(3.dp),
            painter = painterResource(id = icon),
            contentDescription = "Icon"
        )
    }

}
