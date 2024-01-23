package com.example.ui_component

import android.os.Build
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ui_component.values.verticalGradation
import java.time.YearMonth
import java.time.format.TextStyle
import java.time.temporal.TemporalAdjusters
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalScrollCalendar() {
    val page = rememberPagerState { 5 }
    val days = makeCalendar(2024, 2)
    HorizontalPager(
        modifier = Modifier.fillMaxSize(), state = page
    ) {
        CalendarView(days)
    }
}

@Composable
private fun CalendarView(days: List<List<CalendarDate?>>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(20.dp)) {
        days.forEach { week ->
            WeekRow(week)
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun WeekRow(week: List<CalendarDate?>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        week.forEach { day ->
            CalendarItem(day)
        }
    }
}

@Composable
private fun CalendarItem(day: CalendarDate?) {
    Box(modifier = Modifier.size(20.dp)) {
        Text(modifier = Modifier.align(Alignment.Center), text = "${day?.day}")
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