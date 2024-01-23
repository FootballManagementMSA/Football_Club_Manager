package com.example.calendar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.ui_component.HorizontalSpacer
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.values.bigFont
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarControlView(
    year: Int,
    month: Int,
    pagerState: PagerState,
    pageCount: Int
) {
    val coroutineScope = rememberCoroutineScope()
    Text(text = "날짜 선택", fontSize = bigFont)
    VerticalSpacer(value = 10)
    Row {
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
                    pagerState.animateScrollToPage((pagerState.currentPage + 1).coerceAtMost(pageCount))
                }
            },
            imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
            contentDescription = "key"
        )
    }
}