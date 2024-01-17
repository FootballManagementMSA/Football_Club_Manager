package com.example.presentation.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.core.model.ScheduleUiModel
import com.example.presentation.ui_component.MyInfoView
import com.example.presentation.ui_component.ScheduleView
import com.example.presentation.ui_component.StatusView
import com.example.presentation.ui_component.generateDummyData
import com.example.ui_component.values.mainTheme

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    val config = LocalConfiguration.current
    val currentSchedule = remember {
        mutableStateOf(
            ScheduleUiModel(
                schedule = generateDummyData(5)
            ).schedule
        )
    }
    val scrollState = rememberScrollState()
    Column(
        if (isFixed(config))
            Modifier.background(mainTheme)
        else
            Modifier
                .background(mainTheme)
                .verticalScroll(scrollState)
    ) {
        Column(
            if (isFixed(config))
                Modifier
                    .background(mainTheme)
            else
                Modifier
                    .requiredHeightIn(650.dp)
                    .background(mainTheme)
        ) {
            ProfileView(
                modifier = Modifier
                    .requiredHeightIn(min = 250.dp)
                    .weight(4f),
                navHostController = navHostController
            )
            ScheduleView(
                Modifier
                    .requiredHeightIn(min = 400.dp)
                    .weight(7f), currentSchedule
            )
        }
    }

}

private fun isFixed(config: Configuration) = config.screenHeightDp.dp > 650.dp

@Composable
private fun ProfileView(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    Column(modifier) {
        MyInfoView(
            Modifier
                .requiredHeightIn(200.dp)
                .weight(5f), navHostController
        )
        StatusView(
            Modifier
                .requiredHeightIn(min = 100.dp)
                .weight(2f)
                .heightIn(max = 150.dp)
        )
    }
}


@Composable
@Preview
fun MainHomeScreenPreview() {
    HomeScreen(navHostController = rememberNavController())
}