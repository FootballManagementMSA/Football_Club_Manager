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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_joinclub.presentation.ui_component.ClubContent
import com.example.feature_joinclub.presentation.ui_component.ClubItem
import com.example.feature_joinclub.presentation.viewmodel.ClubSearchViewModel
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.values.hugeFont
import com.example.ui_component.values.mainTheme
import com.example.ui_component.values.tinyFont

@Composable
fun ClubSearchScreen(viewModel: ClubSearchViewModel = hiltViewModel()) {
    val teamList = viewModel.searchedClub.collectAsState()
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
            text = viewModel.searchValue.value,
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
    ClubSearchScreen()
}