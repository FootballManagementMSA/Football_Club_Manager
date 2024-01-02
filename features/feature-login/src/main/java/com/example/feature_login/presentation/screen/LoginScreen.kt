package com.example.feature_login.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_login.presentation.viewmodel.LoginViewModel
import com.example.ui_component.CustomGradientButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val idState by viewModel.userId
    val passwordState by viewModel.userPassword
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF232A39))
            .padding(40.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Icon(
                painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
                contentDescription = null,
                modifier = Modifier
                    .size(72.dp)
                    .align(Alignment.Center),
                tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "안녕하세요.\n\n앱이름 입니다.",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = idState,
            label = { Text(text = "학번") },
            placeholder = { Text(text = "학번을 입력해 주세요.") },
            onValueChange = {
                viewModel.updateUserId(it)
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = passwordState,
            label = { Text(text = "비밀번호") },
            placeholder = { Text(text = "비밀번호를 입력해 주세요") },
            onValueChange = {
                viewModel.updateUserPassword(it)
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge
        )
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
        Text(
            text = "비밀번호를 잊으셨습니까?",
            color = Color(0xFF857FEB),
            modifier = Modifier
                .clickable {
                }
                .align(Alignment.CenterHorizontally),
            fontSize = 10.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "아직 계정이 없으신가요?",
            color = Color(0xFF857FEB),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp),
            fontSize = 10.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
            },
            modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth(0.5f)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            contentPadding = PaddingValues(15.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "회원가입", fontSize = 15.sp, color = Color(0xFF857FEB))
        }

    }
}

