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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.model.Club
import com.example.core.model.ClubData
import com.example.core.model.ClubInfo
import com.example.feature_joinclub.presentation.ui_component.ClubContent
import com.example.feature_joinclub.presentation.ui_component.ClubItem
import com.example.feature_joinclub.presentation.ui_component.ClubSearchView
import com.example.feature_joinclub.presentation.viewmodel.ClubSearchViewModel
import com.example.ui_component.template.DefaultBottomSheet
import com.example.ui_component.template.DefaultListView
import com.example.ui_component.values.mainTheme

@Composable
fun JoinClubScreen(
    viewModel: ClubSearchViewModel = hiltViewModel(),
    onNavigateToMakeClub: () -> Unit,
    onNavigateToClubSearch: () -> Unit
) {
    val showSheet = remember {
        mutableStateOf(true)
    }
    val teamList = remember {
        mutableStateOf(
            dummyClub()
        )
    }
    if (showSheet.value) {
        DefaultBottomSheet(onDismiss = { showSheet.value = false }) {
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
                    itemsIndexed(
                        teamList.value.data.team,
                        key = { _, item -> item.name }) { index, club ->
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
                .weight(2f),
            showSheet = { showSheet.value = !showSheet.value },
            onNavigateToMakeClub= onNavigateToMakeClub()
        ) {
            viewModel.searchClub(it)
            onNavigateToClubSearch()
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
    JoinClubScreen(onNavigateToMakeClub = {}) {}
}

fun dummyClub() = Club(
    status = 1,
    code = "code",
    message = "message",
    data = ClubData(
        team = listOf(
            ClubInfo(id = "id", name = "구단명", memberNum = "20", star = 3),
            ClubInfo(id = "id", name = "구단명2", memberNum = "20", star = 3),
            ClubInfo(id = "id", name = "구단명3", memberNum = "20", star = 3),
            ClubInfo(id = "id", name = "구단명4", memberNum = "20", star = 3)
        )
    )
)

