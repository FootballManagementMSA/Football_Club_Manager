package com.example.feature_join.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_join.presentation.ui_component.GenderView
import com.example.feature_join.presentation.viewmodel.JoinViewModel
import com.example.ui_component.CustomGradientButton_1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JoinScreen(
) {
    val viewModel: JoinViewModel = hiltViewModel()
    val scrollState = rememberScrollState()
    var ageText by remember { mutableStateOf("") }
    var HeightText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = Color(0xFF232A39))
            .padding(40.dp)
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "성별과 나이,\n\n키를 알려주세요.",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.height(20.dp))

        GenderView()

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = ageText,
            onValueChange = {
                if (it.isDigitsOnly()) { // 숫자만 받도록
                    ageText = it
                    if (it.isNotEmpty()) {
                        val ageValue = it.toIntOrNull()
                        if (ageValue != null) {
                            viewModel.updateUserAge(ageValue)
                        }                    }
                }
            },
            label = { Text("나이를 입력하세요") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),

            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))


        OutlinedTextField(
            value = HeightText,
            onValueChange = {
                if (it.isDigitsOnly()) { // 숫자만
                    HeightText = it
                    if (it.isNotEmpty()) {
                        val heightValue = it.toIntOrNull()
                        if (heightValue != null) {
                            viewModel.updateUserAge(heightValue)
                        }

                        viewModel.updateUserHeight(it.toInt())
                    }
                }
            },
            label = { Text("키를 입력하세요") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),

            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))

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