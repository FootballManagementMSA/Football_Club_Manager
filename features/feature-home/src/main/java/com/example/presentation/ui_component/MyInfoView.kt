package com.example.presentation.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ui_component.CircleShapeClickableIcon
import com.example.ui_component.HorizontalSpacer
import com.example.ui_component.R
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.values.horizontalGradation
import com.example.ui_component.values.largeIcon
import com.example.ui_component.values.mainTheme
import com.example.ui_component.values.profileInfoButton
import com.example.ui_component.values.tinyFont
import com.example.ui_component.values.veryBigFont

@Composable
fun MyInfoView(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    studentName: String
) {

    Column(
        modifier = modifier
            .padding(30.dp)
            .fillMaxWidth()
    ) {
        Row(
            Modifier,
            verticalAlignment = Alignment.Bottom
        ) {
            Info(
                Modifier
                    .requiredWidthIn(130.dp)
                    .weight(2f)
                    .fillMaxSize(),
                studentName
            )
            ProfileImage(
                Modifier
                    .weight(3f)
                    .padding(top = 10.dp)
            )
        }
    }

}

@Composable
fun Info(modifier: Modifier = Modifier, studentName: String) {
    Column(modifier) {
        VerticalSpacer(value = 10)
        CircleShapeClickableIcon(
            size = largeIcon,
            background = profileInfoButton,
            icon = R.drawable.league_icon
        ) {

        }
        Spacer(modifier = Modifier.height(10.dp))
        CircleShapeClickableIcon(
            size = largeIcon,
            background = profileInfoButton,
            icon = R.drawable.league_icon
        ) {

        }
        Spacer(modifier = Modifier.weight(1f))
        VerticalSpacer(value = 10)
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = studentName,
                fontSize = veryBigFont,
                style = TextStyle(color = Color.White)
            )
            HorizontalSpacer(value = 10)
            Text(
                text = "님의 페이지",
                fontSize = tinyFont,
                style = TextStyle(color = Color.White)
            )
        }
    }
}

//TODO width 가 커지면 깨지는 현상 발생
@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .wrapContentSize()
            .border(width = 3.dp, brush = horizontalGradation, shape = CircleShape),
        painter = painterResource(id = R.drawable.default_profile_image),
        contentDescription = "profileImage"
    )
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
            Info(
                Modifier
                    .weight(1f)
                    .fillMaxSize(),
                studentName = "홍길동"
            )
            ProfileImage(
                Modifier
                    .weight(1f)
                    .fillMaxSize(),
            )
        }
    }
}

@Composable
@Preview
fun ProfileInfoPreview() {
    Info(
        modifier = Modifier
            .height(300.dp)
            .background(mainTheme),
        studentName = "홍길동"
    )
}

@Composable
@Preview
fun ProfileImagePreview() {
    ProfileImage(
        modifier = Modifier
            .height(300.dp)
            .width(300.dp)
            .background(mainTheme)
    )
}
