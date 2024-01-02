package com.example.presentation.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import androidx.navigation.compose.rememberNavController
import com.example.ui_component.CircleShapeClickableIcon
import com.example.ui_component.HorizontalSpacer
import com.example.ui_component.InfoItem
import com.example.ui_component.R
import com.example.ui_component.TopAppBar
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.bigFont
import com.example.ui_component.grayText
import com.example.ui_component.hugeFont
import com.example.ui_component.infoRow
import com.example.ui_component.largeIcon
import com.example.ui_component.mainTheme
import com.example.ui_component.mediumIcon
import com.example.ui_component.profileInfoButton
import com.example.ui_component.smallFont
import com.example.ui_component.tinyFont
import com.example.ui_component.verticalGradation
import com.example.ui_component.veryBigFont

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    BoxWithConstraints(
        Modifier
            .background(mainTheme)
            .fillMaxSize()
            .padding(20.dp)
    ) {
        val height = remember { maxHeight }
        val width = remember { maxWidth }
        Log.e("size", "$height , $width")
        Column(
            Modifier
                .fillMaxSize()
        ) {
            TopAppBar(
                title = "마이페이지",
                actionIcon = Icons.Default.Menu,
                onBack = { navHostController.popBackStack() },
                onAction = { Log.e("MyPage", "show menu") })
            Spacer(
                modifier = Modifier.height(
                    (height / 20).coerceAtLeast(30.dp).coerceAtMost(60.dp)
                )
            )
            ProfileView(height, width)
            Spacer(
                modifier = Modifier.height(
                    (height / 20).coerceAtLeast(30.dp).coerceAtMost(60.dp)
                )
            )
            MyInfoView(height)
        }
    }
}

@Composable
fun MyInfoView(height: Dp) {
    Row(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .height((height / 10).coerceAtLeast(80.dp))
            .background(infoRow),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        InfoItem(title = "나이", content = "25")
        VerticalLine()
        InfoItem(title = "게임 수", content = "70")
        VerticalLine()
        InfoItem(title = "골 수", content = "35")
        VerticalLine()
        InfoItem(title = "주 포메이션", content = "NF")
        VerticalLine()
        InfoItem(title = "주발", content = "L")
    }
}

@Composable
fun VerticalLine() {
    Box(
        Modifier
            .fillMaxHeight()
            .padding(vertical = 16.dp)
            .width(1.dp)
            .background(grayText)
    )
}

@Composable
fun ProfileView(height: Dp, width: Dp) {
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
                height, width / 2
            )
        }
    }
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier, height: Dp, width: Dp) {
    Box(modifier) {
        Box(
            modifier = Modifier
                .size(width.coerceAtMost(200.dp))
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
                fontSize = if (width > 350.dp) hugeFont else veryBigFont,
                style = TextStyle(color = Color.White)
            )
            HorizontalSpacer(value = 10)
            Text(
                text = "님의 페이지",
                fontSize = if (width > 350.dp) smallFont else tinyFont,
                style = TextStyle(color = Color.White)
            )
        }
    }
}

@Composable
@Preview
fun ProfileViewPreview() {
    ProfileView(300.dp, 200.dp)
}

@Composable
@Preview
fun ProfileInfoPreview() {
    ProfileInfo(modifier = Modifier.height(300.dp), 530.dp, 350.dp)
}

@Composable
@Preview
fun ProfileImagePreview() {
    ProfileImage(modifier = Modifier.height(300.dp), 530.dp, 350.dp)
}


@Composable
@Preview
fun MainHomeScreenPreview() {
    HomeScreen(navHostController = rememberNavController())
}