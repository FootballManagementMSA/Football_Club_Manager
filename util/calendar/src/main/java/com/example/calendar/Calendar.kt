package com.example.calendar

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.calendar.model.CalendarDate
import com.example.calendar.util.CalendarUtil.makeCalenderPage
import com.example.calendar.viewmodel.CalendarViewModel
import com.example.ui_component.DefaultRoundedButton
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.values.bigFont
import com.example.ui_component.values.darkButton

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Calendar(
    modifier: Modifier = Modifier,
    viewModel: CalendarViewModel = hiltViewModel(),
    pageCount: Int = 12,
    onSelect: (CalendarDate) -> Unit
) {
    val context = LocalContext.current
    val pagerState = rememberPagerState { pageCount }
    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadCalendar(pageCount)
    }
    when (uiState.value) {
        CalendarState.Loading -> {

        }

        is CalendarState.Success -> {
            val calendarPages = remember { (uiState.value as CalendarState.Success).calendarPage }
            Column(
                modifier
                    .background(Color.White)
            ) {
                Text(text = "날짜 선택", fontSize = bigFont)
                VerticalSpacer(value = 10)
                CalendarControlView(
                    Modifier,
                    calendarPages[pagerState.currentPage].year,
                    calendarPages[pagerState.currentPage].month,
                    pagerState,
                    pageCount
                )
                VerticalSpacer(value = 10)
                HorizontalPager(
                    modifier = modifier.weight(1f), state = pagerState
                ) { monthIndex ->
                    Month(
                        calendarPages[monthIndex].calendar,
                        viewModel.selectedIndex,
                        monthIndex
                    )
                }
                DefaultRoundedButton(
                    modifier = Modifier,
                    cornerRadius = 32.dp,
                    buttonText = "선택",
                    buttonColor = darkButton
                ) {
                    if (viewModel.selectedIndex.value == Triple(-1, -1, -1)) {
                        Toast.makeText(context, "날짜를 선택 해 주세요", Toast.LENGTH_SHORT).show()
                    } else {
                        val (month, week, day) = viewModel.selectedIndex.value
                        onSelect(calendarPages[month].calendar[day][week]!!)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CalendarPreview() {
    Calendar(modifier = Modifier.height(400.dp)) {

    }
}