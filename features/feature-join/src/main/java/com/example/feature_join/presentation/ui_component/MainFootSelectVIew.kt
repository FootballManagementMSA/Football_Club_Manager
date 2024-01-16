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
    var isLeftFootButtonClicked by remember { mutableStateOf(false) }
    var isRightFootButtonClicked by remember { mutableStateOf(false) }
    var isBothFeetButtonClicked by remember { mutableStateOf(false) }


    Row(
        modifier = Modifier
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SelectProfileButton(
            isSelected = isLeftFootButtonClicked,
            onClick = {
                isLeftFootButtonClicked = !isLeftFootButtonClicked
                isBothFeetButtonClicked = false
                isRightFootButtonClicked = false
            },
            contentDescription = "왼발잡이",
            position = "왼발",
            modifier = Modifier.weight(1f).height(30.dp)
        )
        SelectProfileButton(
            isSelected = isRightFootButtonClicked,
            onClick = {
                isRightFootButtonClicked = !isRightFootButtonClicked
                isBothFeetButtonClicked = false
                isLeftFootButtonClicked = false
            },
            contentDescription = "오른발잡이",
            position = "오른발",
            modifier = Modifier.weight(1f).height(30.dp)
        )
        SelectProfileButton(
            isSelected = isBothFeetButtonClicked,
            onClick = {
                isBothFeetButtonClicked = !isBothFeetButtonClicked
                isRightFootButtonClicked = false
                isLeftFootButtonClicked = false
            },
            contentDescription = "양발잡이",
            position = "양발",
            modifier = Modifier.weight(1f).height(30.dp)
        )



    }
}