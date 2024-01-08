package com.example.presentation.ui_component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.model.Schedule
import com.example.ui_component.DefaultItem
import com.example.ui_component.DefaultListView
import com.example.ui_component.RoundedIconButton
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.values.darkGray
import com.example.ui_component.values.horizontalGradation
import com.example.ui_component.values.mainTheme
import com.example.ui_component.values.smallFont

@Composable
fun ScheduleView(modifier: Modifier = Modifier, currentSchedule: State<List<Schedule>>) {
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
                if (currentSchedule.value.isEmpty()) {
                    EmptyScheduleContent()
                } else {
                    DefaultListView(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        listName = "현재 예약된 일정",
                        buttonName = "일정 생성하기",
                        showButton = true,
                        listIcon = Icons.Default.DateRange,
                        onClick = { }) {
                        items(currentSchedule.value) {
                            DefaultItem(
                                modifier = Modifier.padding(bottom = 12.dp),
                                radius = 8.dp
                            ) {
                                Text(text = it.toString())
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ScheduleViewPreview() {
    val state = remember {
        mutableStateOf(generateDummyData(5))
    }
    ScheduleView(currentSchedule = state)
}

@Composable
fun EmptyScheduleContent() {
    val config = LocalConfiguration.current
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
            RoundedIconButton(
                modifier = Modifier.width(config.screenWidthDp.dp / 2),
                icon = Icons.Default.DateRange,
                content = "일정 생성"
            ) {}
        }
    }
}

@Composable
@Preview
fun EmptyScheduleContentPreview() {
    EmptyScheduleContent()
}

fun generateDummyData(count: Int): List<Schedule> {
    val dummyLocations = listOf("Stadium A", "Stadium B", "Stadium C", "Stadium D", "Stadium E")
    val dummyDates = listOf("2022-01-01", "2022-02-15", "2022-03-10", "2022-04-20", "2022-05-05")
    val dummyTeams = listOf("Team Alpha", "Team Beta", "Team Gamma", "Team Delta", "Team Epsilon")

    return (1..count).map {
        Schedule(
            location = dummyLocations.random(),
            date = dummyDates.random(),
            team1 = dummyTeams.random(),
            team2 = dummyTeams.random()
        )
    }
}
