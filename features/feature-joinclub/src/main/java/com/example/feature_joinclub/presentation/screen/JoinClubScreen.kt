package com.example.feature_joinclub.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.model.Club
import com.example.core.model.ClubUiModel
import com.example.ui_component.DefaultItem
import com.example.ui_component.DefaultListView
import com.example.ui_component.values.horizontalGradation
import com.example.ui_component.values.mainTheme
import com.example.ui_component.values.verticalGradation

@Composable
fun JoinClubScreen() {
    val showSheet = remember {
        mutableStateOf(false)
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(mainTheme),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showSheet.value) {
            BottomSheet {
                showSheet.value = false
            }
        }
        Button(onClick = {
            showSheet.value = !showSheet.value
        }) {
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit) {
    val config = LocalConfiguration.current
    val modalBottomSheetState = rememberModalBottomSheetState()
    val teamList = remember {
        mutableStateOf(
            dummyClub()
        )
    }
    ModalBottomSheet(
        modifier = Modifier.height(config.screenHeightDp.dp),
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        val selectedIndex = remember {
            mutableStateOf(-1)
        }
        DefaultListView(
            modifier = Modifier
                .padding(20.dp)
                .selectableGroup(),
            themeColor = Color.Black,
            listName = "현재 가입된 구단 목록",
            listIcon = Icons.Default.Person,
            buttonName = "전체보기",
            showButton = true,
            onClick = { },
            listContent = {
                itemsIndexed(teamList.value.club, key = { _, item -> item.name }) { index, _ ->
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
                        color = Color.White
                    ) {

                    }
                }
            }
        )
    }
}

@Composable
@Preview
fun JoinClubScreenPreview() {
    JoinClubScreen()
}

private fun dummyClub() = ClubUiModel(
    club =
    listOf(
        Club(
            name = "a", "14",
            "hello"
        ),
        Club(
            name = "b", "18",
            "world"
        ), Club(
            name = "c", "18",
            "world"
        ),
        Club(
            name = "d", "18",
            "world"
        ),
        Club(
            name = "e", "18",
            "world"
        ),
        Club(
            name = "f", "14",
            "hello"
        ),
        Club(
            name = "g", "18",
            "world"
        ), Club(
            name = "h", "18",
            "world"
        ),
        Club(
            name = "i", "18",
            "world"
        ),
        Club(
            name = "j", "18",
            "world"
        )
    )
)
