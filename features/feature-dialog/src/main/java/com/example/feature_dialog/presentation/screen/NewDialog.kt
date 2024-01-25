package com.example.feature_dialog.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.core.model.UserInfo
import com.example.feature_dialog.presentation.DialogButton
import com.example.feature_dialog.presentation.DialogContent
import com.example.feature_dialog.presentation.DialogHeader
import com.example.feature_dialog.presentation.DialogTop
import com.example.ui_component.DarkButton
import com.example.ui_component.DialogCustomGradientButton
import com.example.ui_component.HorizontalSpacer
import com.example.ui_component.R
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.values.bigFont
import com.example.ui_component.values.gradientColorsList
import com.example.ui_component.values.smallFont

@Composable
fun NewDialog(
    dialogHeader: DialogHeader,
    dialogTop: DialogTop,
    dialogContent: DialogContent,
    dialogButton: List<DialogButton>
) {
    val config = LocalConfiguration.current
    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = true),
    ) {
        Surface(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(20.dp)
                    .heightIn(min = 270.dp)
                    .height(config.screenHeightDp.dp / 3)
            ) {
                Header(dialogHeader)
                Top(dialogTop)
                Content(dialogContent)
                Buttons(dialogButton)
            }
        }
    }
}

@Preview
@Composable
fun NewDialogPreview() {
    NewDialog(
        dialogHeader = DialogHeader.Default("테스트입니다~", {}),
        dialogTop = DialogTop.Profile,
        dialogContent = DialogContent.Info(userInfo = UserInfo("이윤호", "26", "11", "MF", "하하하.")),
        dialogButton = listOf(DialogButton.Gradient("확인"), DialogButton.Dark("취소"))
    )
}

@Composable
fun Buttons(dialogButton: List<DialogButton>) {
    dialogButton.forEach { button ->
        when (button) {
            is DialogButton.Dark -> {
                DarkButton(
                    buttonText = button.text,
                    textColor = Color.White,
                    roundedCornerShape = RoundedCornerShape(20.dp)
                ) {
                }
            }
            is DialogButton.Gradient -> {
                DialogCustomGradientButton(
                    gradientColors = gradientColorsList,
                    buttonText = button.text,
                    roundedCornerShape = RoundedCornerShape(20.dp)
                ) {

                }
            }
        }
    }
}

@Composable
fun Content(dialogContent: DialogContent) {
    when (dialogContent) {
        is DialogContent.Info -> {
            InfoView(dialogContent.userInfo)
        }
    }
}

@Composable
fun Top(dialogTop: DialogTop) {
    when (dialogTop) {
        is DialogTop.Profile -> {
            DialogProfileView(userName = "이윤호")
        }
    }
}

@Composable
fun Header(dialogHeader: DialogHeader) {
    when (dialogHeader) {
        is DialogHeader.Default -> {
            DialogTopView(Modifier, dialogHeader.title, dialogHeader.dismiss)
        }
    }
}

@Composable
private fun DialogTopView(modifier: Modifier = Modifier, title: String, onDismiss: () -> Unit) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title, fontSize = smallFont, fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = null,
            modifier = Modifier.clickable { onDismiss() })
    }
    VerticalSpacer(value = 10)
}

@Composable
private fun DialogProfileView(modifier: Modifier = Modifier, userName: String) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.default_profile_image),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        HorizontalSpacer(value = 10)
        Text(text = userName, fontSize = bigFont, fontWeight = FontWeight.Bold)
        HorizontalSpacer(value = 4)
        Text(text = "님")
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null
        )
    }
    VerticalSpacer(value = 10)
}

@Composable
fun InfoView(userInfo: UserInfo) {
    Text(text = "나이: ${userInfo.age} ")
    Text(text = "가입 구단 수: ${userInfo.clubNum}")
    Text(text = "주 포메이션: ${userInfo.formation}")
    Text(text = "자기 소개: ${userInfo.selfInfo}")
}