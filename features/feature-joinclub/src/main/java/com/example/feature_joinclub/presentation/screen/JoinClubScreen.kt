package com.example.feature_joinclub.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.feature_joinclub.presentation.ui_component.BottomSheet
import com.example.feature_joinclub.presentation.ui_component.ClubSearchView
import com.example.ui_component.values.mainTheme

@Composable
fun JoinClubScreen() {
    val showSheet = remember {
        mutableStateOf(false)
    }
    if (showSheet.value) {
        BottomSheet {
            showSheet.value = false
        }
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(mainTheme)
            .padding(40.dp)
    ) {
        ClubSearchView(
            Modifier
                .requiredHeightIn(min = 300.dp)
                .weight(2f)
        ){
            showSheet.value = !showSheet.value
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        )
    }
}


@Composable
@Preview
fun JoinClubScreenPreview() {
    JoinClubScreen()
}

