package com.example.feature_makeclub.presentation.ui_component.emblem

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_component.R

@Composable
fun EmblemSelectIconView() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp)
            .clickable { }
    )
    {
        Image(
            painter = painterResource(id = R.drawable.check_icon),
            contentDescription = "CheckIcon",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Preview
@Composable
fun EmblemSelectIconViewPreview() {
    EmblemSelectIconView()
}