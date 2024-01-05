package com.example.feature_join.presentation.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_component.R

@Composable
fun GenderView() {
    var isMaleButtonClicked by remember { mutableStateOf(false) }
    var isFemaleButtonClicked by remember { mutableStateOf(false) }

    Row(
        Modifier
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Box(
            modifier = Modifier
                .size(height = 160.dp, width = 160.dp)
                .clickable {
                    isMaleButtonClicked = true
                    isFemaleButtonClicked = false
                }
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)

        ) {
            Image(
                modifier = Modifier

                    .fillMaxSize()
                    .align(Alignment.Center)
                    .border(
                        width = 1.dp,
                        color = if (isMaleButtonClicked) Color.White else Color.Transparent,
                        shape = MaterialTheme.shapes.medium
                    ),
                painter = painterResource(id = R.drawable.join_male_image),
                contentDescription = "join_male_image"
            )
        }


        Box(
            modifier = Modifier
                .size(height = 160.dp, width = 160.dp)
                .clickable {
                    isFemaleButtonClicked = true
                    isMaleButtonClicked = false
                }

        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
                    .border(
                        width = 1.dp,
                        color = if (isFemaleButtonClicked) Color.White else Color.Transparent,
                        shape = MaterialTheme.shapes.medium
                    )
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center)
                        .padding(if (isFemaleButtonClicked) 1.dp else 0.dp), // 이미지에 테두리를 추가하기 위한 패딩
                    painter = painterResource(id = R.drawable.join_female_image),
                    contentDescription = "join_female_image"
                )
            }
        }
    }
}

@Composable
@Preview
fun GenderPreview() {
    GenderView()
}