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
import com.example.ui_component.R
import com.example.ui_component.values.mainTheme

@Composable
fun JoinSuccessScreen() {


    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = mainTheme)
            .padding(40.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(0.2f),
                painter = painterResource(id = R.drawable.join_success_image),
                contentDescription = "join_success_image"
            )

        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "회원가입이",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "완료되었습니다.",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }

}