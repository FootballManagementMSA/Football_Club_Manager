package com.example.feature_mypage.presentation.ui_component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_component.VerticalSpacer

@Composable
fun MyPageModifyInfoView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(40.dp)
    ) {
        MyPageInfoBar(placeholder = "홍길동", infoText = "이름(닉네임)", isModifyEnable = false)
        MyPageInfoBar(placeholder = "2001년", infoText = "나이 (출생년도)", isModifyEnable = false)
        MyPageInfoBar(placeholder = "180cm", infoText = "키 (cm)", isModifyEnable = false)
        MyPageInfoBar(placeholder = "남성", infoText = "성별", isModifyEnable = true)
        MyPageInfoBar(placeholder = "NF", infoText = "주포메이션", isModifyEnable = true)
        MyPageInfoBar(placeholder = "왼발", infoText = "주발", isModifyEnable = true)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyPageInfoBar(
    modifier: Modifier = Modifier,
    placeholder: String,
    infoText: String,
    isModifyEnable: Boolean
) {
    val text = remember {
        mutableStateOf("")
    }
    Text(text = infoText, style = TextStyle(color = Color.White))
    VerticalSpacer(value = 7)
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = text.value,
        onValueChange = { text.value = it },
        singleLine = true,
        placeholder = {
            Text(text = placeholder)
        },
        trailingIcon = {
            if (isModifyEnable) {
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "")
            }
        })
}

@Preview
@Composable
fun MyPageModifyInfoViewPreview() {
    MyPageModifyInfoView()
}