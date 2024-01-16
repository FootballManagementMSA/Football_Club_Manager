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
    var isSTButtonClicked by remember { mutableStateOf(false) }
    var isMFButtonClicked by remember { mutableStateOf(false) }
    var isDFButtonClicked by remember { mutableStateOf(false) }
    var isGKButtonClicked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SelectProfileButton(
            isSelected = isSTButtonClicked,
            onClick = {
                isSTButtonClicked = !isSTButtonClicked
                isMFButtonClicked = false
                isDFButtonClicked = false
                isGKButtonClicked = false
            },
            contentDescription = "Striker",
            position = "ST",
            modifier = Modifier.weight(1f).height(30.dp)
        )

        SelectProfileButton(
            isSelected = isMFButtonClicked,
            onClick = {
                isMFButtonClicked = !isMFButtonClicked
                isSTButtonClicked = false
                isDFButtonClicked = false
                isGKButtonClicked = false
            },
            contentDescription = "Midfielder",
            position = "MF",
            modifier = Modifier.weight(1f).height(30.dp)
        )

        SelectProfileButton(
            isSelected = isDFButtonClicked,
            onClick = {
                isDFButtonClicked = !isDFButtonClicked
                isMFButtonClicked = false
                isSTButtonClicked = false
                isGKButtonClicked = false
            },
            contentDescription = "Defender",
            position = "DF",
            modifier = Modifier.weight(1f).height(30.dp)
        )

        SelectProfileButton(
            isSelected = isGKButtonClicked,
            onClick = {
                isGKButtonClicked = !isGKButtonClicked
                isMFButtonClicked = false
                isDFButtonClicked = false
                isSTButtonClicked = false
            },
            contentDescription = "Goalkeeper",
            position = "GK",
            modifier = Modifier.weight(1f).height(30.dp)
        )
    }
}