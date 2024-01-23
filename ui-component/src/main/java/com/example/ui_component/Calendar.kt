package com.example.ui_component

import android.os.Build
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_component.values.semiBlue
import com.example.ui_component.values.semiRed
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.YearMonth
import java.time.format.TextStyle
import java.time.temporal.TemporalAdjusters
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalScrollCalendar(modifier: Modifier = Modifier, pageCount: Int = 12) {
    val currentPage = remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState { pageCount }
    val coroutineScope = rememberCoroutineScope()
    val (year, month, calendar) = remember(pagerState.currentPage) {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH) + 1
        val monthOffset = pagerState.currentPage - currentPage.intValue
        val totalMonth = currentMonth + monthOffset
        val adjustedYear = currentYear + (totalMonth - 1) / 12
        val adjustedMonth = if (totalMonth % 12 == 0) 12 else totalMonth % 12
        Triple(adjustedYear, adjustedMonth, makeCalendar(adjustedYear, adjustedMonth))
    }
    Column(modifier.fillMaxSize()) {
        MonthControlView(year, month, coroutineScope, pagerState, pageCount)
        HorizontalPager(
            modifier = modifier.weight(1f), state = pagerState
        ) {
            CalendarView(calendar) { month }
        }
        DefaultRoundedButton(
            modifier = Modifier.padding(20.dp),
            cornerRadius = 32.dp,
            buttonText = "날짜 선택"
        ) {

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun MonthControlView(
    year: Int,
    month: Int,
    coroutineScope: CoroutineScope,
    pagerState: PagerState,
    pageCount: Int
) {
    Row(Modifier.padding(20.dp)) {
        Text(text = "$year 년 $month 월")
        HorizontalSpacer(value = 10)
        Icon(
            modifier = Modifier.clickable {
                coroutineScope.launch {
                    pagerState.animateScrollToPage((pagerState.currentPage - 1).coerceAtLeast(0))
                }
            },
            imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
            contentDescription = "key"
        )
        HorizontalSpacer(value = 10)
        Icon(
            modifier = Modifier.clickable {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(
                        (pagerState.currentPage + 1).coerceAtMost(
                            pageCount
                        )
                    )
                }
            },
            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
            contentDescription = "key"
        )
    }
}


@Composable
private fun CalendarView(days: List<List<CalendarDate?>>, month: () -> Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(20.dp)) {
        DaysOfWeekView(Modifier.weight(0.5f))
        days.forEach { week ->
            WeekRow(week, month)
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun DaysOfWeekView(modifier: Modifier = Modifier) {
    val dayOfWeekList = remember { listOf("일", "월", "화", "수", "목", "금", "토") }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        dayOfWeekList.forEachIndexed { index, dayOfWeek ->
            Box(modifier = Modifier.size(20.dp)) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = dayOfWeek,
                    color = when (index) {
                        0 -> Color.Red
                        dayOfWeekList.size - 1 -> Color.Blue
                        else -> Color.Black
                    }
                )
            }
        }
    }
    Spacer(modifier = modifier)
}

val dayOfWeekToCalendarDay = mapOf(
    "Sun" to Calendar.SUNDAY,
    "Mon" to Calendar.MONDAY,
    "Tue" to Calendar.TUESDAY,
    "Wed" to Calendar.WEDNESDAY,
    "Thu" to Calendar.THURSDAY,
    "Fri" to Calendar.FRIDAY,
    "Sat" to Calendar.SATURDAY,
    "일" to Calendar.SUNDAY,
    "월" to Calendar.MONDAY,
    "화" to Calendar.TUESDAY,
    "수" to Calendar.WEDNESDAY,
    "목" to Calendar.THURSDAY,
    "금" to Calendar.FRIDAY,
    "토" to Calendar.SATURDAY
)

@Composable
private fun WeekRow(week: List<CalendarDate?>, month: () -> Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        week.forEach { day ->
            CalendarItem(day, month)
        }
    }
}

@Composable
private fun CalendarItem(day: CalendarDate?, month: () -> Int) {
    Box(modifier = Modifier.size(20.dp)) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "${day?.day}",
            color = when {
                day?.month != month() && dayOfWeekToCalendarDay[day?.dayOfWeek] == Calendar.SUNDAY -> semiRed
                day?.month != month() && dayOfWeekToCalendarDay[day?.dayOfWeek] == Calendar.SATURDAY -> semiBlue
                day?.month != month() -> Color.Gray
                dayOfWeekToCalendarDay[day.dayOfWeek] == Calendar.SUNDAY -> Color.Red
                dayOfWeekToCalendarDay[day.dayOfWeek] == Calendar.SATURDAY -> Color.Blue
                else -> Color.Black
            }
        )
    }
}

data class CalendarDate(
    val year: Int,
    val month: Int,
    val day: Int,
    val dayOfWeek: String
)

fun makeCalendar(year: Int, month: Int): List<List<CalendarDate?>> {
    val daysList = MutableList(5) { MutableList<CalendarDate?>(7) { null } }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val firstDayOfMonth = YearMonth.of(year, month).atDay(1)
        var currentDay =
            firstDayOfMonth.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.SUNDAY))

        for (week in 0 until 5) {
            for (dayOfWeek in 0 until 7) {
                val adjustedYear =
                    if (month == 1 && currentDay.monthValue == 12) year - 1 else if (month == 12 && currentDay.monthValue == 1) year + 1 else year
                if (currentDay.monthValue == month || currentDay.isBefore(firstDayOfMonth) || currentDay.monthValue == (month % 12) + 1) {
                    val dayName =
                        currentDay.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
                    daysList[week][dayOfWeek] =
                        CalendarDate(
                            adjustedYear,
                            currentDay.monthValue,
                            currentDay.dayOfMonth,
                            dayName
                        )
                }
                currentDay = currentDay.plusDays(1)
            }
        }
    } else {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month - 1)
            set(Calendar.DAY_OF_MONTH, 1)
        }

        val firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK)
        calendar.add(Calendar.DATE, -firstDayOfMonth + Calendar.SUNDAY)

        for (week in 0 until 5) {
            for (dayOfWeek in 0 until 7) {
                val adjustedYear = calendar.get(Calendar.YEAR)
                val adjustedMonth =
                    calendar.get(Calendar.MONTH) + 1
                val dayName =
                    calendar.getDisplayName(
                        Calendar.DAY_OF_WEEK,
                        Calendar.SHORT,
                        Locale.getDefault()
                    )

                if (adjustedMonth == month || calendar.before(Calendar.getInstance().apply {
                        set(Calendar.YEAR, year)
                        set(Calendar.MONTH, month - 1)
                        set(Calendar.DAY_OF_MONTH, 1)
                    }) || adjustedMonth == (month % 12) + 1) {
                    daysList[week][dayOfWeek] = CalendarDate(
                        adjustedYear,
                        adjustedMonth,
                        calendar.get(Calendar.DAY_OF_MONTH),
                        dayName ?: ""
                    )
                }

                calendar.add(Calendar.DATE, 1)
            }
        }
    }

    return daysList
}

@Preview
@Composable
fun CalendarPreview() {
    HorizontalScrollCalendar(modifier = Modifier.height(400.dp))
}