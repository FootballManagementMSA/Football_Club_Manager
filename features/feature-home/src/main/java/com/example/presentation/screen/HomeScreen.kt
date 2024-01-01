package com.example.presentation.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.viewmodel.MainHomeViewModel
import com.example.ui_component.TopAppBar
import com.example.ui_component.mainTheme

@Composable
fun HomeScreen(
    viewModel: MainHomeViewModel = hiltViewModel(),
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
    }
}