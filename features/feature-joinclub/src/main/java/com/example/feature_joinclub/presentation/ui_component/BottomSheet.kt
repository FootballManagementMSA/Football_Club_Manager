package com.example.feature_joinclub.presentation.ui_component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.core.model.Club
import com.example.core.model.ClubUiModel
import com.example.ui_component.DefaultListView

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
                itemsIndexed(teamList.value.club, key = { _, item -> item.name }) { index, club ->
                    ClubItem(selectedIndex, index) { ClubContent(club = club) }
                }
            }
        )
    }
}

fun dummyClub() = ClubUiModel(
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