package com.example.feature_mypage.presentation.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_component.R
import com.example.ui_component.values.darkGray

@Composable
fun MyPageInfoView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.default_profile_image),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .offset(y = (-30).dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "홍 길 동", color = Color.White, modifier = Modifier
                .offset(y = (-10).dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "202012345",
            color = darkGray,
            modifier = Modifier
                .offset(y = (-5).dp)
                .align(Alignment.CenterHorizontally)

        )
    }
}

@Preview
@Composable
fun MyPageInfoViewPreview() {
    MyPageInfoView()
}
