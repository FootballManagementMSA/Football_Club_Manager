package com.example.feature_join.presentation.screen

import GenderView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_join.presentation.ui_component.InputView_OnlyNum
import com.example.feature_join.presentation.viewmodel.JoinViewModel
import com.example.ui_component.CustomGradientButton_1
import com.example.ui_component.values.mainTheme

@Composable
fun JoinScreen(viewModel: JoinViewModel = hiltViewModel()) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = mainTheme)
            .padding(40.dp)
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))


        Text(
            text = "성별과 나이,\n\n키를 알려주세요!!",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(40.dp))

        //

        GenderView()
        Spacer(modifier = Modifier.height(10.dp))


        InputView_OnlyNum(
            state = viewModel.userAge,
            label = "나이(출생년도)",
            placeholder = "나이를 입력해주세요.",
            onValueChanges = { viewModel.updateUserAge(it) })


        Spacer(modifier = Modifier.height(10.dp))
        InputView_OnlyNum(
            state = viewModel.userHeight,
            label = "키(cm)",
            placeholder = "키를 입력해주세요.",
            onValueChanges = { viewModel.updateUserHeight(it) })


        Spacer(modifier = Modifier.height(20.dp))

        CustomGradientButton_1(
            gradientColors = listOf(Color(0xFFEE6DE7), Color(0xFF857FEB)),
            cornerRadius = 16.dp,
            buttonText = "시작하기",
            roundedCornerShape = RoundedCornerShape(20.dp)

        ) {
            // viewModel.join()
        }

    }
}

