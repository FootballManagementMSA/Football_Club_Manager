package com.example.ui_component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RoundedIconButton(width: Dp, onClick : () -> Unit) {
    Box(
        modifier = Modifier
            .clickable {
                onClick()
            }
    ) {
        Row(
            Modifier
                .clip(
                    RoundedCornerShape(30.dp)
                )
                .width(width)
                .background(Color.White)
                .padding(8.dp)
                .align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = ""
            )
            Text(text = "일정 생성", fontWeight = FontWeight.Bold)
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = ""
            )
        }
    }
}