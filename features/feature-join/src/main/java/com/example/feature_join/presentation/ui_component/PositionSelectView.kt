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
fun PositionSelectView() {
    // -1: 초기 아무것도 X, 0: ST, 1: MF, 2: DF, 3: GK
    var selectedPositionIndex by remember { mutableStateOf(-1) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SelectProfileButton(
            isSelected = selectedPositionIndex == 0,
            onClick = {
                selectedPositionIndex = if (selectedPositionIndex == 0) -1 else 0
            },
            contentDescription = "공격수",
            position = "ST",
            modifier = Modifier.weight(1f).height(30.dp)
        )

        SelectProfileButton(
            isSelected = selectedPositionIndex == 1,
            onClick = {
                selectedPositionIndex = if (selectedPositionIndex == 1) -1 else 1
            },
            contentDescription = "미드필더",
            position = "MF",
            modifier = Modifier.weight(1f).height(30.dp)
        )

        SelectProfileButton(
            isSelected = selectedPositionIndex == 2,
            onClick = {
                selectedPositionIndex = if (selectedPositionIndex == 2) -1 else 2
            },
            contentDescription = "수비수",
            position = "DF",
            modifier = Modifier.weight(1f).height(30.dp)
        )

        SelectProfileButton(
            isSelected = selectedPositionIndex == 3,
            onClick = {
                selectedPositionIndex = if (selectedPositionIndex == 3) -1 else 3
            },
            contentDescription = "골키퍼",
            position = "GK",
            modifier = Modifier.weight(1f).height(30.dp)
        )
    }
}