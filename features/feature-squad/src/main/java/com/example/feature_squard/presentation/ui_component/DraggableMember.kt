package com.example.feature_squard.presentation.ui_component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.core.model.LocalScreen
import com.example.core.model.MemberUiModel
import com.example.core.model.Position
import com.example.ui_component.R
import kotlin.math.roundToInt

@Composable
fun DraggableMember(
    onLoad: () -> Pair<MemberUiModel,LocalScreen>,
    onDrag: (MemberUiModel) -> Unit,
) {
    var member by remember { mutableStateOf(onLoad().first) }
    val screenSize by remember { mutableStateOf(onLoad().second) }
    val draggableModifier = remember {
        Modifier
            .offset {
                IntOffset(
                    member.position.x
                        .roundToInt()
                        .coerceAtLeast(0)
                        .coerceAtMost(screenSize.width.toInt()),
                    member.position.y
                        .roundToInt()
                        .coerceAtLeast(0)
                        .coerceAtMost(screenSize.height.toInt()),
                )
            }
            .pointerInput(Unit) {
                detectTapGestures (
                    onLongPress = {
                        Log.e("name",member.name)
                    }
                )
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    member = member.copy(
                        position = Position(
                            x = (member.position.x + dragAmount.x)
                                .coerceAtLeast(0f)
                                .coerceAtMost(screenSize.width.toFloat()),
                            y = (member.position.y + dragAmount.y)
                                .coerceAtLeast(0f)
                                .coerceAtMost(screenSize.height.toFloat())
                        )
                    )
                    onDrag(member)
                }
            }
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = draggableModifier.size(20.dp),
            painter = painterResource(id = R.drawable.cloth_icon),
            contentDescription = member.name
        )
        Spacer(modifier = draggableModifier.padding(vertical = 3.dp))
        Text(modifier = draggableModifier.wrapContentSize(), text = member.name, color = Color.White)
    }
}
