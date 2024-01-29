package com.example.feature_schedule

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ui_component.template.DefaultEmblemSelectIconView
import com.example.ui_component.values.mainTheme

@Composable
fun MakeScheduleScreen() {
    val uri = remember { mutableStateOf<Uri?>(null) }
    val title = remember { mutableStateOf("") }
    val memo = remember { mutableStateOf("") }
    val startDate = remember { mutableStateOf("") }
    val endDate = remember { mutableStateOf("") }
    val location = remember { mutableStateOf("") }
    Column(
        Modifier
            .background(mainTheme)
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "일정 제목")
                DefaultEmblemSelectIconView(
                    modifier = Modifier
                        .size(60.dp)
                        .padding(top = 5.dp),
                    state = uri
                ) {

                }
            }
            InputView(
                modifier = Modifier.fillMaxWidth(),
                text = { title.value },
                onChange = { title.value = it }, placeholder = "일정 제목을 입력해주세요."
            )
        }

        Row {

        }
    }
}

@Composable
fun InputView(
    modifier: Modifier = Modifier,
    text: () -> String,
    onChange: (String) -> Unit,
    placeholder: String
) {
    Column {
        BasicTextField(
            modifier = modifier,
            value = text(),
            onValueChange = onChange,
            decorationBox = {
                if (text().isEmpty()) {
                    Text(modifier = Modifier.padding(4.dp), text = placeholder, color = Color.Gray)
                }
                it()
            }
        )
        Box(
            modifier
                .background(Color.White)
                .height(1.dp)
        )
    }

}