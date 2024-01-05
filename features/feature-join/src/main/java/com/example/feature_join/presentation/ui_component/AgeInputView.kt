@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.feature_join.presentation.ui_component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AgeinputView() {


    var age by remember { mutableStateOf(TextFieldValue()) }

    // 입력 안내 문구
    Column() {

        OutlinedTextField(
            value = age,
            onValueChange = {
                if (it.text.isNotEmpty() && it.text.all { it.isDigit() }) {
                    age = it
                } else {
                    age = TextFieldValue()
                }
            },
            label = {
                Text("나이를 입력하세요")
            },
            modifier = Modifier.fillMaxWidth()
        )
    }

}


@Composable
@Preview
fun AgePreView() {
}