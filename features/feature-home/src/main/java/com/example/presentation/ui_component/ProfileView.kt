package com.example.presentation.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.coerceAtMost
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ui_component.CircleShapeClickableIcon
import com.example.ui_component.HorizontalSpacer
import com.example.ui_component.R
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.bigFont
import com.example.ui_component.hugeFont
import com.example.ui_component.largeIcon
import com.example.ui_component.mainTheme
import com.example.ui_component.mediumIcon
import com.example.ui_component.profileInfoButton
import com.example.ui_component.smallFont
import com.example.ui_component.tinyFont
import com.example.ui_component.verticalGradation
import com.example.ui_component.veryBigFont

@Composable
fun ProfileView(
    navHostController: NavHostController,
    height: Dp,
    width: Dp
) {
    Column(Modifier.padding(20.dp)) {
        Spacer(
            modifier = Modifier.height(
                (height / 20).coerceAtLeast(30.dp).coerceAtMost(60.dp)
            )
        )
        Column(
            modifier = Modifier
                .height(
                    (height / 3)
                        .coerceAtLeast(150.dp)
                        .coerceAtMost(200.dp)
                )
                .fillMaxWidth()
        ) {
            Row(Modifier) {
                ProfileInfo(
                    Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    height, width
                )
                ProfileImage(
                    Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    height, width
                )
            }
        }
    }
}

@Composable
fun ProfileInfo(modifier: Modifier = Modifier, height: Dp, width: Dp) {
    Column(modifier) {
        CircleShapeClickableIcon(
            size = if (height > 500.dp) largeIcon else mediumIcon,
            background = profileInfoButton,
            icon = R.drawable.league_icon
        ) {

        }
        Spacer(modifier = Modifier.height(10.dp))
        CircleShapeClickableIcon(
            size = if (height > 500.dp) largeIcon else mediumIcon,
            background = profileInfoButton,
            icon = R.drawable.league_icon
        ) {

        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(if (height > 500.dp) largeIcon else mediumIcon),
                painter = painterResource(id = R.drawable.cloth_icon),
                contentDescription = "cloth"
            )
            HorizontalSpacer(value = 10)
            Text(text = "07", fontSize = bigFont, style = TextStyle(color = Color.White))
        }
        VerticalSpacer(value = 10)
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "홍길동",
                fontSize = if (width > 390.dp) hugeFont else veryBigFont,
                style = TextStyle(color = Color.White)
            )
            HorizontalSpacer(value = 10)
            Text(
                text = "님의 페이지",
                fontSize = if (width > 390.dp) smallFont else tinyFont,
                style = TextStyle(color = Color.White)
            )
        }
    }
}

//TODO width 가 커지면 깨지는 현상 발생
@Composable
fun ProfileImage(modifier: Modifier = Modifier, height: Dp, width: Dp) {
    Box(modifier) {
        Box(
            modifier = Modifier
                .size(
                    (260.dp)
                        .coerceAtMost(width / 2 - 20.dp)
                )
                .clip(CircleShape)
                .background(verticalGradation)
                .align(Alignment.BottomEnd)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(3.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.default_profile_image),
                contentDescription = "profileImage"
            )
        }
    }
}

@Composable
@Preview
fun ProfileViewPreview() {
    Column(
        modifier = Modifier
            .background(mainTheme)
            .height(
                250.dp
            )
            .fillMaxWidth()
    ) {
        Row(Modifier) {
            ProfileInfo(
                Modifier
                    .weight(1f)
                    .fillMaxSize(),
                800.dp, 400.dp
            )
            ProfileImage(
                Modifier
                    .weight(1f)
                    .fillMaxSize(),
                800.dp, 400.dp
            )
        }
    }
}

@Composable
@Preview
fun ProfileInfoPreview() {
    ProfileInfo(modifier = Modifier
        .height(300.dp)
        .background(mainTheme), 800.dp, 400.dp)
}

@Composable
@Preview
fun ProfileImagePreview() {
    ProfileImage(modifier = Modifier
        .height(300.dp)
        .background(mainTheme), 800.dp, 400.dp)
}
