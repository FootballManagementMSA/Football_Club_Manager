package com.example.feature_schedule

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calendar.Calendar
import com.example.ui_component.buttons.CustomGradientButton
import com.example.ui_component.template.DefaultBottomSheet
import com.example.ui_component.template.DefaultEmblemSelectIconView
import com.example.ui_component.values.emblem
import com.example.ui_component.values.gradientColorsList
import com.example.ui_component.values.mainTheme
import com.example.ui_component.values.middleFont
import com.example.ui_component.values.tinyFont

@Composable
fun MakeScheduleScreen() {
    val uri = remember { mutableStateOf<Uri?>(null) }
    val title = remember { mutableStateOf("") }
    val memo = remember { mutableStateOf("") }
    val startDate = remember { mutableStateOf("") }
    val endDate = remember { mutableStateOf("") }
    val location = remember { mutableStateOf("") }
    val showCalendar = remember { mutableStateOf(false) }
    val setStart = remember { mutableStateOf(false) }
    if (showCalendar.value) {
        DefaultBottomSheet(onDismiss = { showCalendar.value = false }) {
            Calendar(
                modifier = Modifier
                    .padding(20.dp)
                    .height(350.dp)
            ) {
                if (setStart.value) {
                    startDate.value = "${it.year}-${it.month}-${it.day}"
                    setStart.value = false
                } else {
                    endDate.value = "${it.year}-${it.month}-${it.day}"
                }
                showCalendar.value = false
            }
        }
    }
    Column(
        Modifier
            .background(mainTheme)
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "일정 제목", color = Color.Gray)
                DefaultEmblemSelectIconView(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(emblem)
                        .size(60.dp)
                        .padding(top = 5.dp),
                    state = uri,
                    defaultIcon = com.example.ui_component.R.drawable.league_icon
                ) {

                }
            }
            InputView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                text = { title.value },
                onChange = { title.value = it }, placeholder = "일정 제목을 입력해주세요."
            )
        }
        Spacer(modifier = Modifier.weight(0.4f))
        Text("일정 메모", color = Color.Gray)
        InputView(
            modifier = Modifier
                .fillMaxWidth(),
            text = { memo.value },
            onChange = { memo.value = it }, placeholder = "메모를 입력해주세요."
        )
        Spacer(modifier = Modifier.weight(0.4f))
        Text(text = "일정 날짜", color = Color.Gray)
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            InputView(
                modifier = Modifier
                    .weight(1f),
                text = { startDate.value },
                onChange = { startDate.value = it }, placeholder = "시작 날짜를 입력해주세요.",
                leadingIcon = {
                    Icon(
                        modifier = Modifier.clickable {
                            showCalendar.value = true
                            setStart.value = true
                        },
                        imageVector = Icons.Default.DateRange,
                        contentDescription = ""
                    )
                }
            )
            Box(
                modifier = Modifier
                    .width(10.dp)
                    .height(1.dp)
                    .background(Color.Gray)
            )
            InputView(
                modifier = Modifier
                    .weight(1f),
                text = { endDate.value },
                onChange = { endDate.value = it }, placeholder = "종료 날짜를 입력해주세요.",

                leadingIcon = {
                    Icon(
                        modifier = Modifier.clickable {
                            showCalendar.value = true
                        },
                        imageVector = Icons.Default.DateRange,
                        contentDescription = ""
                    )
                }
            )
        }
        Spacer(modifier = Modifier.weight(0.4f))
        Text("일정 장소", color = Color.Gray)
        InputView(
            modifier = Modifier
                .fillMaxWidth(),
            text = { location.value },
            onChange = { location.value = it }, placeholder = "일정 장소를 입력해주세요."
        )
        Spacer(modifier = Modifier.weight(0.4f))
        Text("상대팀 성정", color = Color.Gray)
        Row(verticalAlignment = Alignment.CenterVertically) {
            DefaultEmblemSelectIconView(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(emblem)
                    .size(40.dp)
                    .padding(top = 5.dp),
                state = uri,
                defaultIcon = com.example.ui_component.R.drawable.league_icon
            ) {

            }
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "vs",
                color = Color.Gray,
                fontSize = middleFont
            )
            DefaultEmblemSelectIconView(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(emblem)
                    .size(40.dp)
                    .padding(top = 5.dp),
                state = uri,
                defaultIcon = com.example.ui_component.R.drawable.league_icon
            ) {

            }
        }
        Spacer(modifier = Modifier.weight(1f))
        CustomGradientButton(
            gradientColors = gradientColorsList,
            cornerRadius = 8.dp,
            buttonText = "수락하기",
            roundedCornerShape = RoundedCornerShape(8.dp)
        ) {

        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
fun MakeScheduleScreenPreview() {
    MakeScheduleScreen()
}


@Composable
fun InputView(
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    text: () -> String,
    onChange: (String) -> Unit,
    placeholder: String
) {
    TextField(
        modifier = modifier.height(50.dp),
        value = text(),
        leadingIcon = leadingIcon,
        onValueChange = onChange,
        placeholder = { Text(text = placeholder, fontSize = tinyFont) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = mainTheme,
            focusedContainerColor = mainTheme,
        )
    )

}