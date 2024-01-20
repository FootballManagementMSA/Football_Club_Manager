package com.example.feature_squard.presentation.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.core.model.PositionPresetUIModel
import com.example.core.model.PositionUiModel
import com.example.ui_component.R
import kotlin.math.roundToInt

@Composable
fun DraggableMember(
    memberNumber: Int,
    onLoad: () -> PositionPresetUIModel,
    onSet: (PositionUiModel) -> Unit
) {
    val loaded = remember { mutableStateOf(onLoad().memberPosition[memberNumber]) }
    val screenSize by remember { mutableStateOf(onLoad().screenSize) }
    val boxSize = remember { mutableStateOf(20) }
    Image(
        modifier = Modifier
            .offset {
                IntOffset(
                    loaded.value.x
                        .roundToInt()
                        .coerceAtLeast(0)
                        .coerceAtMost(screenSize.width.toInt() - boxSize.value * 2),
                    loaded.value.y
                        .roundToInt()
                        .coerceAtLeast(0)
                        .coerceAtMost(screenSize.height.toInt()),
                )
            }
            .size(boxSize.value.dp)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    loaded.value = loaded.value.copy(
                        x = (loaded.value.x + dragAmount.x)
                            .coerceAtLeast(0f)
                            .coerceAtMost(screenSize.width.toFloat()),
                        y = (loaded.value.y + dragAmount.y)
                            .coerceAtLeast(0f)
                            .coerceAtMost(screenSize.height.toFloat()),
                    )
                    onSet(loaded.value)
                }
            }, painter = painterResource(id = R.drawable.cloth_icon), contentDescription = "member"
    )
}
