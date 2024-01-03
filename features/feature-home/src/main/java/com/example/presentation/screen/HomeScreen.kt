package com.example.presentation.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.presentation.ui_component.MyInfoView
import com.example.presentation.ui_component.ProfileView
import com.example.presentation.ui_component.ScheduleView
import com.example.ui_component.mainTheme

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    val scrollState = rememberScrollState()
    val currentSchedule = remember {
        mutableStateListOf<Int?>()
    }
    BoxWithConstraints(
        Modifier
            .background(mainTheme)
            .fillMaxSize()
    ) {
        val height = remember { maxHeight }
        val width = remember { maxWidth }
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            ProfileView(navHostController, height, width)
            MyInfoView(height)
            ScheduleView(currentSchedule, width)
        }
    }
}


@Composable
@Preview
fun MainHomeScreenPreview() {
    HomeScreen(navHostController = rememberNavController())
}