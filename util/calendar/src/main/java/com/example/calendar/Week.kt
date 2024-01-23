package com.example.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.calendar.model.CalendarDate


@Composable
fun Week(
    week: List<CalendarDate?>,
    columnIndex: Int,
    selectedIndex: MutableState<Pair<Int, Int>>,
    onSelect: (CalendarDate) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectableGroup(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        week.forEachIndexed { rowIndex, day ->
            Day(day, rowIndex, columnIndex, selectedIndex, onSelect)
        }
    }
}