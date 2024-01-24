package com.example.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calendar.model.CalendarDate
import com.example.calendar.values.calendarDateSize
import com.example.calendar.values.dayOfWeekToCalendarDay
import com.example.ui_component.values.semiBlue
import com.example.ui_component.values.semiRed
import java.util.Calendar

@Composable
fun Day(
    calendarDate: CalendarDate?,
    rowIndex: Int,
    columnIndex: Int,
    pageIndex: Int,
    selectedIndex: MutableState<Triple<Int, Int, Int>>,
    onSelect: (CalendarDate) -> Unit
) {
    val calendar = remember { Calendar.getInstance() }
    val currentMonth = remember { calendar.get(Calendar.MONTH) + pageIndex + 1 }
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .selectable(
                selected = selectedIndex.value == Triple(columnIndex, rowIndex, pageIndex),
                onClick = {
                    if (selectedIndex.value == Triple(columnIndex, rowIndex, pageIndex))
                        selectedIndex.value = Triple(-1, -1, -1)
                    else {
                        selectedIndex.value = Triple(columnIndex, rowIndex, pageIndex)
                        calendarDate?.let { onSelect(it) }
                    }
                }
            )
            .background(if (selectedIndex.value == Triple(columnIndex, rowIndex, pageIndex)) Color.Black else Color.White)
            .size(calendarDateSize)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(4.dp),
            text = "${calendarDate?.day}",
            color = when {
                selectedIndex.value == Triple(columnIndex, rowIndex, pageIndex) -> Color.White
                calendarDate?.month != currentMonth && dayOfWeekToCalendarDay[calendarDate?.dayOfWeek] == Calendar.SUNDAY -> semiRed
                calendarDate?.month != currentMonth && dayOfWeekToCalendarDay[calendarDate?.dayOfWeek] == Calendar.SATURDAY -> semiBlue
                calendarDate?.month != currentMonth -> Color.Gray
                dayOfWeekToCalendarDay[calendarDate.dayOfWeek] == Calendar.SUNDAY -> Color.Red
                dayOfWeekToCalendarDay[calendarDate.dayOfWeek] == Calendar.SATURDAY -> Color.Blue
                else -> Color.Black
            }
        )
    }
}

@Preview
@Composable
fun DaySelectedPreview() {
    val selectedIndex = remember { mutableStateOf(Triple(0,0,0)) }
    Day(
        calendarDate = CalendarDate(2024, 1, 24, "목"),
        rowIndex = 0,
        columnIndex = 0,
        pageIndex = 0,
        selectedIndex = selectedIndex,
    ) {

    }
}

@Preview
@Composable
fun DayNotSelectedPreview() {
    val selectedIndex = remember { mutableStateOf(Triple(-1,-1,-1)) }
    Day(
        calendarDate = CalendarDate(2024, 1, 24, "목"),
        rowIndex = 0,
        columnIndex = 0,
        pageIndex = 0,
        selectedIndex = selectedIndex,
    ) {

    }
}