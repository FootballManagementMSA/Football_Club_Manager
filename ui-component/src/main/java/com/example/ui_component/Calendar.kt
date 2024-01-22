package com.example.ui_component

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ui_component.values.verticalGradation
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.time.temporal.TemporalAdjusters
import java.util.Locale

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalScrollCalendar() {
    val page = rememberPagerState { 5 }
    val days = make(2024, 2)  // 2024년 1월에 대한 일자와 요일 리스트
    days.forEach { week ->
        week.forEach { day ->
            if (day != null) {
                Log.e("123","${day.day}(${day.dayOfWeek}) ")
            } else {
                Log.e("123","   ")
            }
        }
        println()
    }
    HorizontalPager(
        modifier = Modifier
            .background(verticalGradation), state = page
    ) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

            }
        }
    }
}

data class Day(
    val year: Int,
    val month: Int,
    val day: Int,
    val dayOfWeek: String
)


@RequiresApi(Build.VERSION_CODES.O)
fun make(year: Int, month: Int): List<List<Day?>> {
    val daysList = MutableList(5) { MutableList<Day?>(7) { null } } // 6행 7열 리스트 초기화

    val firstDayOfMonth = YearMonth.of(year, month).atDay(1)
    var currentDay = firstDayOfMonth.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.SUNDAY))

    for (week in 0 until 5) {
        for (dayOfWeek in 0 until 7) {
            val adjustedYear = if (month == 1 && currentDay.monthValue == 12) year - 1 else if (month == 12 && currentDay.monthValue == 1) year + 1 else year
            if (currentDay.monthValue == month || currentDay.isBefore(firstDayOfMonth) || currentDay.monthValue == (month % 12) + 1) {
                val dayName = currentDay.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
                daysList[week][dayOfWeek] = Day(adjustedYear, currentDay.monthValue, currentDay.dayOfMonth, dayName)
            }
            currentDay = currentDay.plusDays(1)
        }
    }

    return daysList
}