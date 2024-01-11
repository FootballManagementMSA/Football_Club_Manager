package com.example.feature_squard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt
import com.example.ui_component.R
import com.example.ui_component.values.mainTheme

@Composable
fun DraggableScreen() {
    DraggableBox()
}


@Composable
private fun DraggableBox() {
    Box(modifier = Modifier.fillMaxSize().background(mainTheme)) {
        Draggable { x, y ->

        }
        Draggable { x, y ->

        }
        Draggable { x, y ->

        }
    }
}

@Composable
private fun Draggable(onSet: (Int, Int) -> Unit) {
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    Image(
        modifier = Modifier
            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            .size(50.dp)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    offsetX += dragAmount.x
                    offsetY += dragAmount.y
                }
            }, painter = painterResource(id = R.drawable.cloth_icon), contentDescription = "member"
    )
}