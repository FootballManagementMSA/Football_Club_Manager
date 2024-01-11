package com.example.feature_mypage.presentation.screen

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.feature_mypage.presentation.ui_component.MyPageModifyInfoView
import com.example.feature_mypage.presentation.ui_component.MyPageTopView
import com.example.ui_component.CustomGradientButton
import com.example.ui_component.DefaultEmblemSelectIconView
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.values.gradientColorsList
import com.example.ui_component.values.mainTheme

@Composable
fun MyPageModifyScreen() {
    val state = remember { mutableStateOf<Uri?>(null) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(mainTheme)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        MyPageTopView(title = "마이페이지", onBack = {}) {
        }

        DefaultEmblemSelectIconView(
            modifier = Modifier.fillMaxWidth(),
            state = state,
            onSelect = {})
        MyPageModifyInfoView(modifier = Modifier.fillMaxWidth())
        CustomGradientButton(
            gradientColors = gradientColorsList,
            cornerRadius = 16.dp,
            buttonText = "확인",
            roundedCornerShape = RoundedCornerShape(20.dp)
        ) {
        }
        VerticalSpacer(value = 55)
    }
}

@Preview
@Composable
fun MyPageModifyScreenPreview() {
    MyPageModifyScreen()
}