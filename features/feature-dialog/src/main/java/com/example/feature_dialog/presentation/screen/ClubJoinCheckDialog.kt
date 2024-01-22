package com.example.feature_dialog.presentation.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.model.UserInfo
import com.example.ui_component.DarkButton
import com.example.ui_component.DefaultDialog
import com.example.ui_component.DialogCustomGradientButton
import com.example.ui_component.HorizontalSpacer
import com.example.ui_component.values.gradientColorsList

@Composable
fun ClubJoinCheckDialog(userInfo: UserInfo) {
    DefaultDialog(title = "멤버 가입 신청입니다.", userName = "홍길동") {
        Text(text = "나이: ${userInfo.age} ")
        Text(text = "가입 구단 수: ${userInfo.clubNum}")
        Text(text = "주 포메이션: ${userInfo.formation}")
        Text(text = "자기 소개: ${userInfo.selfInfo}")

        Row() {
            DarkButton(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                buttonText = "거절하기",
                textColor = Color.White,
                roundedCornerShape = RoundedCornerShape(20.dp)
            ) {
            }
            HorizontalSpacer(value = 15)
            DialogCustomGradientButton(
                modifier = Modifier.weight(1f),
                gradientColors = gradientColorsList,
                buttonText = "수락하기",
                roundedCornerShape = RoundedCornerShape(20.dp)
            )  {

            }
        }
    }
}

@Preview
@Composable
fun ClubJoinCheckDialogPreview() {
    ClubJoinCheckDialog(UserInfo("30", "3", "GK", "자기소개입니다."))
}