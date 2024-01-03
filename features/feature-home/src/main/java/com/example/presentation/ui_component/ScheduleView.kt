package com.example.presentation.ui_component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui_component.RoundedIconButton
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.darkGray
import com.example.ui_component.horizontalGradation
import com.example.ui_component.mainTheme
import com.example.ui_component.smallFont

@Composable
fun ScheduleView(modifier: Modifier = Modifier, currentSchedule: SnapshotStateList<Int?>) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("일정")

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        ScrollableTabRow(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 20.dp),
            edgePadding = 0.dp,
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->

            },
            divider = {
                Box(
                    Modifier
                        .height(7.dp)
                        .background(horizontalGradation)
                ) {

                }
            },
            containerColor = mainTheme
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            text = title,
                            color = Color.White,
                            fontSize = smallFont,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    }
                )
            }
        }

        when (selectedTabIndex) {
            0 -> {
                if (currentSchedule.isEmpty()) {
                    EmptyScheduleContent()
                } else {

                }
            }
        }
    }
}

@Composable
@Preview
fun ScheduleViewPreview() {
    ScheduleView(currentSchedule = SnapshotStateList())
}

@Composable
fun EmptyScheduleContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(darkGray)
                .height(1.dp)
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .wrapContentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "예정된 일정이 없습니다. \n 지금 일정을 만들어 보세요!",
                textAlign = TextAlign.Center,
                color = darkGray,
                fontWeight = FontWeight.Bold
            )
            VerticalSpacer(value = 14)
            RoundedIconButton(200.dp) {}
        }
    }
}

@Composable
@Preview
fun EmptyScheduleContentPreview() {
    EmptyScheduleContent()
}
