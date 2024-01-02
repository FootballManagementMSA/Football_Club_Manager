package com.example.presentation.ui_component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui_component.InfoItem
import com.example.ui_component.VerticalLine
import com.example.ui_component.infoRow

@Composable
fun MyInfoView(height: Dp) {
    Row(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .height((height / 10).coerceAtLeast(80.dp))
            .background(infoRow),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        InfoItem(title = "나이", content = "25")
        VerticalLine()
        InfoItem(title = "게임 수", content = "70")
        VerticalLine()
        InfoItem(title = "골 수", content = "35")
        VerticalLine()
        InfoItem(title = "주 포메이션", content = "NF")
        VerticalLine()
        InfoItem(title = "주발", content = "L")
    }
}

@Composable
@Preview
fun MyInfoViewPreview() {
    MyInfoView(height = 800.dp)
}