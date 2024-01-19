package com.example.feature_joinclub.presentation.ui_component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.model.Club
import com.example.ui_component.DefaultItem
import com.example.ui_component.HorizontalSpacer
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.values.horizontalGradation
import com.example.ui_component.values.tinyFont
import com.example.ui_component.values.veryBigFont

@Composable
fun ClubItem(
    selectedIndex: MutableState<Int>,
    index: Int,
    content: @Composable () -> Unit
) {
    DefaultItem(
        modifier = Modifier
            .padding(bottom = 12.dp)
            .selectable(
                selected = selectedIndex.value == index,
                onClick = {
                    if (selectedIndex.value == index)
                        selectedIndex.value = -1
                    else
                        selectedIndex.value = index
                }
            )
            .border(
                width = 2.dp,
                brush = if (selectedIndex.value == index) horizontalGradation else Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFFFFFFF)
                    )
                ),
                shape = RoundedCornerShape(8.dp)
            ),
        radius = 8.dp,
        color = Color.White,
        content = content
    )
}

@Composable
fun ClubContent(club: Club) {
    Row(
        Modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(Modifier) {
            Text(text = club.name, fontWeight = FontWeight.Bold, fontSize = veryBigFont)
            VerticalSpacer(value = 10)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "")
                HorizontalSpacer(value = 5)
                Text(text = "${club.person} 명", fontSize = tinyFont)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "")
                HorizontalSpacer(value = 5)
                Text(text = club.introduction, fontSize = tinyFont)
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f),
                imageVector = Icons.Default.Settings,
                contentDescription = "Icon"
            )
            Icon(
                modifier = Modifier,
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = "Icon"
            )
        }
    }
}

@Composable
@Preview
fun ClubItemPreview() {
    ClubItem(selectedIndex = mutableStateOf(1), index = 1) {
        ClubContent(club = Club("a", "12", "hi"))
    }
}