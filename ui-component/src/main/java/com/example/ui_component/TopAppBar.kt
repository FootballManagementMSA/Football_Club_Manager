package com.example.ui_component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    actionIcon: ImageVector,
    onBack: () -> Unit,
    onAction: () -> Unit
) {
    Row(
        modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Icon(
            modifier = modifier
                .size(bigIcon)
                .clickable {
                    onBack()
                },
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "NavIcon",
            tint = Color.White
        )
        Text(text = title, style = TextStyle(color = Color.White), fontSize = appBarFont)
        Icon(
            modifier = modifier
                .size(bigIcon)
                .clickable {
                    onAction()
                },
            imageVector = actionIcon,
            contentDescription = "Action",
            tint = Color.White
        )
    }
}
