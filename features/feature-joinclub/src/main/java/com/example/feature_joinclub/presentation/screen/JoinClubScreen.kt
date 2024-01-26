package com.example.feature_joinclub.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.model.Club
import com.example.core.model.ClubUiModel
import com.example.ui_component.DefaultBottomSheet
import com.example.feature_joinclub.presentation.ui_component.ClubContent
import com.example.feature_joinclub.presentation.ui_component.ClubItem
import com.example.feature_joinclub.presentation.ui_component.ClubSearchView
import com.example.ui_component.DefaultListView
import com.example.ui_component.values.mainTheme

@Composable
fun JoinClubScreen() {
    val showSheet = remember {
        mutableStateOf(false)
    }
    val teamList = remember {
        mutableStateOf(
            dummyClub()
        )
    }
    if (showSheet.value) {
        DefaultBottomSheet(onDismiss = {showSheet.value = false}) {
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

