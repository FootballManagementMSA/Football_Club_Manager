package com.example.calendar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calendar.model.CalendarDate
import com.example.calendar.util.CalendarUtil.makeCalendar
import com.example.ui_component.DefaultRoundedButton
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.values.bigFont
import com.example.ui_component.values.darkButton
import java.util.Calendar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Calendar(
    modifier: Modifier = Modifier,
    pageCount: Int = 12,
    onSelect: (CalendarDate) -> Unit
) {
    val pagerState = rememberPagerState { pageCount }
    val calendar = remember { Calendar.getInstance() }
    val currentYear = remember { calendar.get(Calendar.YEAR) }
    val currentMonth = remember { calendar.get(Calendar.MONTH) + 1 }
    val currentDay = remember { calendar.get(Calendar.DAY_OF_MONTH) }
    val selectedDate =
        remember { mutableStateOf(CalendarDate(currentYear, currentMonth, currentDay, "Empty")) }
    val calendarPages = remember {
        List(pageCount) { pageIndex ->
            val totalMonth = currentMonth + pageIndex
            val adjustedYear = currentYear + (totalMonth - 1) / 12
            val adjustedMonth = if (totalMonth % 12 == 0) 12 else totalMonth % 12
            CalendarPage(adjustedYear, adjustedMonth, makeCalendar(adjustedYear, adjustedMonth))
        }
    }
    Column(
        modifier
            .fillMaxSize()
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
        ) { pageIndex ->
            Month(calendarPages[pageIndex].calendar, pageIndex) { selectedDate.value = it }
        }
        DefaultRoundedButton(
            modifier = Modifier,
            cornerRadius = 32.dp,
            buttonText = "선택",
            buttonColor = darkButton
        ) {
            onSelect(selectedDate.value)
        }
    }
}

data class CalendarPage(
    val year: Int,
    val month: Int,
    val calendar: List<List<CalendarDate?>>
)

@Preview
@Composable
fun CalendarPreview() {
    Calendar(modifier = Modifier.height(400.dp)) {

    }
}