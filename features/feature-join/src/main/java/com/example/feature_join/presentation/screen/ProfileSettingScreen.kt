package com.example.feature_join.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_join.presentation.ui_component.InputView_OnlyNum
import com.example.feature_join.presentation.ui_component.MainFootSelectView
import com.example.feature_join.presentation.ui_component.PositionSelectView
import com.example.feature_join.presentation.viewmodel.JoinViewModel
import com.example.ui_component.CustomGradientButton_1
import com.example.ui_component.R
import com.example.ui_component.values.mainTheme

@Composable
fun ProfileSettingScreen(viewModel: JoinViewModel = hiltViewModel()) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = mainTheme)
            .padding(40.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))


        Text(
            text = "프로필을,",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "설정해주세요.",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(0.3f),
                painter = painterResource(id = R.drawable.select_profile_image),
                contentDescription = "select_profile_image"
            ) // 버튼 클릭시 이미지 선택창으로 이동하도록 구현해야함

        }

        Spacer(modifier = Modifier.height(20.dp))

        InputView_OnlyNum(
            state = viewModel.userName,
            label = "이름(닉네임)",
            placeholder = "이름을 입력해주세요.",
            onValueChanges = { viewModel.updateUserName(it) })


        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "주포메이션",
            fontSize = 11.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 200.dp)

        )
        PositionSelectView()
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "주발",
            fontSize = 11.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 230.dp)

        )
        MainFootSelectView()


        Spacer(modifier = Modifier.height(20.dp))


        CustomGradientButton_1(
            gradientColors = listOf(Color(0xFFEE6DE7), Color(0xFF857FEB)),
            cornerRadius = 16.dp,
            buttonText = "다음",
            roundedCornerShape = RoundedCornerShape(20.dp)

        ) {

        }

    }
}
