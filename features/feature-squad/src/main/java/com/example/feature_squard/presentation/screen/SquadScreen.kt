package com.example.feature_squard.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_squard.presentation.Position
import com.example.feature_squard.presentation.SquadState
import com.example.feature_squard.presentation.viewmodel.SquadViewModel
import kotlin.math.roundToInt
import com.example.ui_component.R
import com.example.ui_component.values.mainTheme

@Composable
fun SquadScreen(viewModel: SquadViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.loadPreset()
    }
    when (state) {
        is SquadState.Loading -> {
            CircularProgressIndicator()
        }

        is SquadState.Success -> {
            DraggableBox(onLoad = {
                (state as SquadState.Success).data.user1
            }, onSet = { position ->
                viewModel.savePosition(position)
            })
        }
    }
}


@Composable
private fun DraggableBox(onLoad: () -> Position, onSet: (Position) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mainTheme)
    ) {
        Draggable(onLoad, onSet)
    }
}

@Composable
private fun Draggable(onLoad: () -> Position, onSet: (Position) -> Unit) {
    val loaded = remember { mutableStateOf(onLoad()) }
    Image(
        modifier = Modifier
            .offset { IntOffset(loaded.value.x.roundToInt(), loaded.value.y.roundToInt()) }
            .size(50.dp)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    loaded.value = loaded.value.copy(x = loaded.value.x + dragAmount.x, y = loaded.value.y + dragAmount.y)
                }
            }, painter = painterResource(id = R.drawable.cloth_icon), contentDescription = "member"
    )
}