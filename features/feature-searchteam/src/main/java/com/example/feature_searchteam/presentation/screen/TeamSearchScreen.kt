package com.example.feature_searchteam.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.auto_complete.AutoComplete
import com.example.ui_component.DarkButton
import com.example.ui_component.DefaultBottomSheet
import com.example.ui_component.HorizontalSpacer
import com.example.ui_component.values.bigFont

data class TempClubInfo(val name: String, val code: String)

@Composable
fun TeamSearchScreen() {
    var showSheet by remember { mutableStateOf(false) }
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Button(onClick = { showSheet = !showSheet }) {
            Text(text = "bottomsheet")
        }
        if (showSheet) {
            DefaultBottomSheet(onDismiss = { showSheet = false }) {
                ClubSearchView(onDismiss = { showSheet = false })
            }
        }
    }
}

@Composable
fun ClubSearchView(onDismiss: () -> Unit) {
    val categoryList = dummy()
    Column(Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp)) {
        Header(Modifier.weight(2f), title = "상대팀 검색") {
            onDismiss()
        }
        AutoComplete(
            modifier = Modifier.weight(8f),
            placeholder = "상대 구단을 검색해주세요.",
            items = categoryList,
            itemFilter = {
                it.name
            }
        ) {
            Text(text = it.name)
            HorizontalSpacer(value = 5)
            Text(fontSize = 10.sp, text = "구단 고유 코드 : ${it.code}")
        }
        DarkButton(
            Modifier
                .padding(15.dp)
                .weight(1f),
            buttonText = "선택",
            textColor = Color.White,
            radius = 20.dp
        ) {

        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun Header(modifier: Modifier = Modifier, title: String, onDismiss: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title, fontSize = bigFont, fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = null,
            modifier = Modifier.clickable { onDismiss() })
    }
}

@Composable
fun dummy(): List<TempClubInfo> {
    return remember {
        listOf(
            TempClubInfo("Liverpool", "2221"),
            TempClubInfo("Arsenal", "2223"),
            TempClubInfo("Man City", "33130"),
            TempClubInfo("Manchest United", "4678"),
            TempClubInfo("Brighton", "7890"),
            TempClubInfo("brentford", "36458"),
            TempClubInfo("Burnley", "w234"),
            TempClubInfo("luton", "wy765"),
            TempClubInfo("Siuuu", "133252")
        )
    }
}

@Preview
@Composable
fun ClubSearchViewPreview() {
    ClubSearchView {

    }
}

@Preview
@Composable
fun TestScreenPreview() {
    TeamSearchScreen()
}