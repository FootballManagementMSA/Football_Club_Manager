package com.example.feature_clubpage.presentation.viewmodel.screen


import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import com.example.core.model.ScheduleUiModel
import com.example.feature_clubpage.presentation.ui_component.ClubInfoView
import com.example.feature_clubpage.presentation.viewmodel.ui_component.ScheduleView
import com.example.feature_clubpage.presentation.viewmodel.ui_component.generateDummyData
import com.example.ui_component.values.mainTheme

@Composable
fun ClubPageScreen() {
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
        if (isScrollable(config))
            Modifier
        else
            Modifier.verticalScroll(scrollState)
    ) {
        Column(
            if (isScrollable(config))
                Modifier
                    .background(mainTheme)
            else
                Modifier
                    .requiredHeightIn(800.dp)
                    .background(mainTheme)
        ) {
            ProfileView(
                modifier = Modifier
                    .weight(3f)
            )
            ScheduleView(
                Modifier
                    .weight(7f), currentSchedule
            )
        }
    }

}

private fun isScrollable(config: Configuration) = config.screenHeightDp.dp > 800.dp

@Composable
private fun ProfileView(
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        ClubInfoView(
            Modifier
                .requiredHeightIn(200.dp)
                .weight(5f)
        )

    }
}


@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileView()
}

@Composable
@Preview
fun ClubPageScreenPreview() {
    ClubPageScreen()
}