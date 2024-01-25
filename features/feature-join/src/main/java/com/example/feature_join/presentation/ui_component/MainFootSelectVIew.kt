package com.example.feature_join.presentation.ui_component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainFootSelectView() {
    // -1: 초기 아무것도 x, 0: 왼발, 1: 오른발, 2: 양발
    var selectedFootIndex by remember { mutableStateOf(-1) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SelectProfileButton(
            isSelected = selectedFootIndex == 0,
            onClick = {
                selectedFootIndex = if (selectedFootIndex == 0) -1 else 0
            },
            contentDescription = "왼발잡이",
            position = "왼발",
            modifier = Modifier.weight(1f).height(30.dp)
        )
        SelectProfileButton(
            isSelected = selectedFootIndex == 1,
            onClick = {
                selectedFootIndex = if (selectedFootIndex == 1) -1 else 1
            },
            contentDescription = "오른발잡이",
            position = "오른발",
            modifier = Modifier.weight(1f).height(30.dp)
        )
        SelectProfileButton(
            isSelected = selectedFootIndex == 2,
            onClick = {
                selectedFootIndex = if (selectedFootIndex == 2) -1 else 2
            },
            contentDescription = "양발잡이",
            position = "양발",
            modifier = Modifier.weight(1f).height(30.dp)
        )
    }
}