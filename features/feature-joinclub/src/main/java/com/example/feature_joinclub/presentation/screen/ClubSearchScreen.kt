package com.example.feature_joinclub.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.model.ClubInfo
import com.example.feature_joinclub.presentation.ui_component.ClubContent
import com.example.feature_joinclub.presentation.ui_component.ClubItem
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.values.hugeFont
import com.example.ui_component.values.mainTheme
import com.example.ui_component.values.tinyFont

@Composable
fun ClubSearchScreen(
    teamList: State<List<ClubInfo>>,
    value: String,
    ) {
    val selectedIndex = remember {
        mutableStateOf(-1)
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(mainTheme)
            .padding(40.dp)
    ) {
        Box(Modifier.fillMaxWidth()) {
            Icon(
                modifier = Modifier.align(Alignment.CenterEnd),
                imageVector = Icons.Default.Menu,
                contentDescription = "",
                tint = Color.White
            )
        }
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            fontSize = hugeFont,
            color = Color.White
        )
        Text(
            text = "에 대한 검색결과",
            fontWeight = FontWeight.Bold,
            fontSize = hugeFont,
            color = Color.White
        )
        VerticalSpacer(value = 10)
        Text(
            text = "구단의 이름이나 코드로 검색 할 수 있어요.",
            fontWeight = FontWeight.Bold,
            fontSize = tinyFont,
            color = Color.White
        )
        VerticalSpacer(value = 20)
        LazyColumn(Modifier.fillMaxSize()) {
            itemsIndexed(
                teamList.value,
                key = { _, item -> item.uniqueNum }) { index, club ->
                ClubItem(selectedIndex, index) { ClubContent(club = club) }
            }
        }

    }

}

@Composable
@Preview
fun ClubSearchScreenPreview() {
    val sampleClubList = listOf(
        ClubInfo(teamId = 3, teamName = "Test", totalMemberCnt = 10, details = "", uniqueNum = "bcd", emblem = ""),
        ClubInfo(teamId = 3, teamName = "Test", totalMemberCnt = 10, details = "", uniqueNum = "bcd2", emblem = "")
    )

    ClubSearchScreen(
        teamList = remember { mutableStateOf(sampleClubList) },
        value = "Test"
    )
}