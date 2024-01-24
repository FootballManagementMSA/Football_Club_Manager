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
    selectedIndex: MutableState<Pair<Int, Int>>,
    onSelect: (CalendarDate) -> Unit
) {
    val calendar = remember { Calendar.getInstance() }
    val currentMonth = remember { calendar.get(Calendar.MONTH) + 1 }
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .selectable(
                selected = selectedIndex.value == columnIndex to rowIndex,
                onClick = {
                    if (selectedIndex.value == columnIndex to rowIndex)
                        selectedIndex.value = -1 to -1
                    else {
                        selectedIndex.value = columnIndex to rowIndex
                        calendarDate?.let { onSelect(it) }
                    }
                }
            )
            .background(if (selectedIndex.value == columnIndex to rowIndex) Color.Black else Color.White)
            .size(calendarDateSize)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(4.dp),
            text = "${calendarDate?.day}",
            color = when {
                selectedIndex.value == columnIndex to rowIndex -> Color.White
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
    val selectedIndex = remember { mutableStateOf(0 to 0) }
    Day(
        calendarDate = CalendarDate(2024, 1, 24, "목"),
        rowIndex = 0,
        columnIndex = 0,
        selectedIndex = selectedIndex,
    ) {

    }
}

@Preview
@Composable
fun DayNotSelectedPreview() {
    val selectedIndex = remember { mutableStateOf(-1 to -1) }
    Day(
        calendarDate = CalendarDate(2024, 1, 24, "목"),
        rowIndex = 0,
        columnIndex = 0,
        selectedIndex = selectedIndex,
    ) {

    }
}