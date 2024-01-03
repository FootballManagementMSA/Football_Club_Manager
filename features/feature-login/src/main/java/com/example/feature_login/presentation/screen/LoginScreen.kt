package com.example.feature_login.presentation.screen

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_login.presentation.ui_component.IconView
import com.example.feature_login.presentation.ui_component.LoginClickableTextView
import com.example.feature_login.presentation.viewmodel.LoginViewModel
import com.example.ui_component.CustomGradientButton
import com.example.ui_component.InputView
import com.example.ui_component.WhiteButton


@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = Color(0xFF232A39))
            .padding(40.dp)
    ) {
        IconView()

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "안녕하세요.\n\n앱이름 입니다.",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        InputView(
            state = viewModel.userId,
            label = " 학번",
            placeholder = "학번을 입력해 주세요.",
            onValueChange = { viewModel.updateUserId(it) })

        Spacer(modifier = Modifier.height(15.dp))

        InputView(
            state = viewModel.userPassword,
            label = "비밀번호",
            placeholder = "비밀번호를 입력해 주세요",
            onValueChange = { viewModel.updateUserPassword(it) })

        Spacer(modifier = Modifier.height(35.dp))

        CustomGradientButton(
            gradientColors = listOf(Color(0xFFEE6DE7), Color(0xFF857FEB)),
            cornerRadius = 16.dp,
            buttonText = "로그인",
            roundedCornerShape = RoundedCornerShape(20.dp)
        ) {
            viewModel.login()
        }

        Spacer(modifier = Modifier.height(16.dp))

        LoginClickableTextView()

        Spacer(modifier = Modifier.height(10.dp))

        WhiteButton(
            buttonText = "회원가입",
            textColor = Color(0xFF857FEB),
            roundedCornerShape = RoundedCornerShape(20.dp)
        ) {
        }
    }
}
