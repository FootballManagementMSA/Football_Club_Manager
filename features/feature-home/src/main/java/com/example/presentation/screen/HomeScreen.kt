package com.example.presentation.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ui_component.CircleShapeClickableIcon
import com.example.ui_component.R
import com.example.ui_component.TopAppBar
import com.example.ui_component.bigIcon
import com.example.ui_component.hugeIcon
import com.example.ui_component.mainTheme
import com.example.ui_component.profileInfoButton
import com.example.ui_component.verticalGradation

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    Column(
        Modifier
            .background(mainTheme)
            .fillMaxSize()
            .padding(24.dp)
    ) {
        TopAppBar(
            title = "마이페이지",
            actionIcon = Icons.Default.Menu,
            onBack = { navHostController.popBackStack() },
            onAction = { Log.e("MyPage", "show menu") })
        ProfileView(
            Modifier
                .fillMaxWidth()
                .weight(1f),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
        ) {

        }
    }
}

@Composable
private fun ProfileView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            ProfileInfoView(Modifier.weight(1f))
            ProfileImageView()
        }
    }
}

@Composable
private fun ProfileInfoView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        CircleShapeClickableIcon(hugeIcon, profileInfoButton, R.drawable.league_icon) {
            //do nothing
        }
        Spacer(modifier = Modifier.height(10.dp))
        CircleShapeClickableIcon(hugeIcon, profileInfoButton, R.drawable.league_icon) {
            //do nothing
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(bigIcon),
                painter = painterResource(id = R.drawable.cloth_icon),
                contentDescription = "cloth"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "07", fontSize = 30.sp, style = TextStyle(color = Color.White))
        }
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(text = "홍길동", fontSize = 32.sp, style = TextStyle(color = Color.White))
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "님의 페이지", fontSize = 12.sp, style = TextStyle(color = Color.White))
        }
    }
}

@Composable
private fun ProfileImageView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(196.dp)
            .clip(CircleShape)
            .background(verticalGradation)
    ) {
        Image(
            modifier = Modifier.padding(3.dp),
            painter = painterResource(id = R.drawable.default_profile_image),
            contentDescription = "profile_Image"
        )
    }
}

@Composable
@Preview
fun MainHomeScreenPreview(){
    HomeScreen(navHostController = rememberNavController())
}