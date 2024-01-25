package com.example.feature_dialog.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_dialog.presentation.viewmodel.DialogViewModel
@Composable
fun DialogTestScreen(viewModel: DialogViewModel = hiltViewModel()) {
    val userInfos = viewModel.joinClubUserInfo.collectAsState()
    val isDialogOpen = remember { mutableStateListOf<Boolean>() }

    Column(modifier = Modifier.background(Color.White)) {
        Button(onClick = {
            isDialogOpen.clear()
            isDialogOpen.addAll(List(userInfos.value.size) { true })
        }) {
            Text(text = "모든 다이얼로그 보기")
        }

        userInfos.value.forEachIndexed { index, userInfo ->
            if (isDialogOpen.getOrNull(index) == true) {
                ClubJoinCheckDialog(
                    userInfo = userInfo,
                    onDismiss = { isDialogOpen[index] = false }
                )
            }
        }
    }
}

@Preview
@Composable
fun DialogTestScreenPreview() {
    DialogTestScreen()
}