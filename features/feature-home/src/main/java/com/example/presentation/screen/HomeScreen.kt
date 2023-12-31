package com.example.presentation.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.viewmodel.TestViewModel
import com.example.ui_component.TestComponent

@Composable
fun HomeScreen(viewModel: TestViewModel = hiltViewModel()) {
    val state = viewModel.uiState.collectAsState()
    viewModel.getResponse()
    LaunchedEffect(Unit){
    }
    
    when(state.value){
        "Http 200" -> {
            TestComponent(text = "Http Request Success")
        }
    }
}