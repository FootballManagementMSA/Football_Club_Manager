package com.example.feature_mypage.presentation.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_mypage.presentation.ui_component.ModifyProfileImageView
import com.example.feature_mypage.presentation.ui_component.MyPageModifyInfoView
import com.example.feature_mypage.presentation.viewmodel.MyPageViewModel
import com.example.ui_component.CustomGradientButton
import com.example.ui_component.values.gradientColorsList
import com.example.ui_component.values.mainTheme

@Composable
fun MyPageModifyScreen(
    viewModel: MyPageViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    val config = LocalConfiguration.current
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
                    .requiredHeightIn(950.dp)
                    .background(mainTheme)
        ) {
            ModifyProfileImageView(
                modifier = Modifier
                    .requiredHeightIn(min = 200.dp)
                    .weight(2f),
                viewModel.selectedImageUri.collectAsState()
            ) {
                viewModel.updateSelectedImageUri(it)
            }
            MyPageModifyInfoView(
                modifier = Modifier
                    .requiredHeightIn(min = 650.dp)
                    .weight(8f)
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .requiredHeightIn(100.dp)
                    .align(Alignment.CenterHorizontally)
                    .width(300.dp)
            ) {
                CustomGradientButton(
                    gradientColors = gradientColorsList,
                    cornerRadius = 16.dp,
                    buttonText = "확인",
                    roundedCornerShape = RoundedCornerShape(20.dp)
                ) {
                }
            }
        }
    }
}

private fun isScrollable(config: Configuration) = config.screenHeightDp.dp > 950.dp

@Preview
@Composable
fun MyPageModifyScreenPreview() {
    MyPageModifyScreen()
}