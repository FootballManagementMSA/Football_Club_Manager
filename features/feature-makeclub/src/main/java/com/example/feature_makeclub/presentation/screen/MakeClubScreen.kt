package com.example.feature_makeclub.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_makeclub.presentation.ui_component.make_club.ClubIdInfoBox
import com.example.feature_makeclub.presentation.ui_component.make_club.ClubNameInputField
import com.example.feature_makeclub.presentation.ui_component.make_club.ClubNameView
import com.example.feature_makeclub.presentation.ui_component.make_club.MakeClubTopView
import com.example.feature_makeclub.presentation.viewmodel.MakeClubViewModel
import com.example.ui_component.buttons.CustomGradientButton
import com.example.ui_component.values.gradientColorsList
import com.example.ui_component.values.mainTheme

@Composable
fun MakeClubScreen(
    viewModel: MakeClubViewModel = hiltViewModel(),
    onNavigateToEmblemSelect: () -> Unit
) {
    val scrollState = rememberScrollState()
    val clubName = viewModel.clubName.collectAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = mainTheme)
            .padding(40.dp)
    ) {
        MakeClubTopView()
        ClubNameView()
        ClubNameInputField(
            state = clubName,
            onValueChange = { viewModel.updateClubName(it) })
        ClubIdInfoBox(text = "중복되는 이름도 신규 생성 가능합니다.")
        CustomGradientButton(
            gradientColors = gradientColorsList,
            cornerRadius = 16.dp,
            buttonText = "다음",
            roundedCornerShape = RoundedCornerShape(20.dp)
        ) {
            onNavigateToEmblemSelect()
        }
    }
}

@Preview
@Composable
fun MakeClubScreenPreview() {
    MakeClubScreen(onNavigateToEmblemSelect = {})
}