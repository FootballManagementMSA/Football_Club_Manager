package com.example.feature_squard.presentation.screen

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.model.Position
import com.example.feature_squard.presentation.SquadState
import com.example.feature_squard.presentation.viewmodel.SquadViewModel
import kotlin.math.roundToInt
import com.example.ui_component.R
import com.example.ui_component.values.mainTheme

@Composable
fun SquadScreen(viewModel: SquadViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsState()
    val config = LocalConfiguration.current
    LaunchedEffect(Unit) {
        viewModel.loadPreset()
    }
    when (state) {
        is SquadState.Loading -> {
            CircularProgressIndicator()
        }

        is SquadState.Success -> {
            DraggableBox(
                config = config,
                onLoad = { (state as SquadState.Success).data.user1 },
                onSet = { position ->
                    Log.e("callback","$position")
                    viewModel.savePosition(position)
                })
        }
    }
}


@Composable
private fun DraggableBox(config: Configuration, onLoad: () -> Position, onSet: (Position) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mainTheme)
    ) {
        Draggable(config, onLoad, onSet)
    }
}

@Composable
private fun Draggable(config: Configuration, onLoad: () -> Position, onSet: (Position) -> Unit) {
    val loaded =
        remember {
            mutableStateOf(
                Position(
                    onLoad().x * (config.screenWidthDp - 50),
                    onLoad().y * (config.screenHeightDp - 170)
                )
            )
        }
    Log.e("123", "${loaded.value}")
    Image(
        modifier = Modifier
            .offset(x = loaded.value.x.dp, y = loaded.value.y.dp)
            .size(50.dp)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    loaded.value = loaded.value.copy(
                        x = loaded.value.x + dragAmount.x,
                        y = loaded.value.y + dragAmount.y
                    )
                    onSet(
                        Position(
                            loaded.value.x / config.screenWidthDp,
                            loaded.value.y / config.screenHeightDp
                        )
                    )
                }
            }, painter = painterResource(id = R.drawable.cloth_icon), contentDescription = "member"
    )
}