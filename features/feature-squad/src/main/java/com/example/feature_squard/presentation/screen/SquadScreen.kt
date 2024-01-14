package com.example.feature_squard.presentation.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.model.Position
import com.example.core.model.PositionPreset
import com.example.core.model.Screen
import com.example.feature_squard.presentation.SquadState
import com.example.feature_squard.presentation.viewmodel.SquadViewModel
import com.example.ui_component.R
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.values.mainTheme
import com.example.ui_component.values.subTheme
import com.example.ui_component.values.tinyFont
import kotlin.math.roundToInt

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
            SquadContent(
                onLoad = { (state as SquadState.Success).data },
                onSet = { position ->
                    Log.e("callback", "$position")
                    viewModel.savePosition(position)
                })
        }
    }
}


@Composable
private fun SquadContent(onLoad: () -> PositionPreset, onSet: (Position) -> Unit) {
    val member1Position = remember { mutableStateOf(Position(0f, 0f)) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(mainTheme)
            .padding(10.dp)
    ) {
        Column(Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                painter = painterResource(id = R.drawable.field),
                contentDescription = "field"
            )
            VerticalSpacer(value = 10)
            CandidateView()
        }
        DraggableMember(onLoad){
            member1Position.value = it
            Log.e("state","${member1Position.value}")
        }
        Button(modifier = Modifier.align(Alignment.TopEnd),onClick = { onSet(member1Position.value) }) {
            Text(text = "save preset")
        }
    }
}

@Composable
private fun CandidateView() {
    Text(
        text = "교체 선수",
        fontSize = tinyFont,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
    VerticalSpacer(value = 10)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(subTheme)
            .wrapContentHeight()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            modifier = Modifier
                .padding(5.dp)
                .size(20.dp),
            painter = painterResource(id = R.drawable.cloth_icon),
            contentDescription = ""
        )
    }
}

@Composable
private fun DraggableMember(onLoad: () -> PositionPreset, onSet: (Position) -> Unit) {
    val loaded = remember { mutableStateOf(onLoad().user1) }
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

@Composable
@Preview
fun SquadContentPreview() {
    SquadContent(onLoad = {
        PositionPreset(
            screenSize = Screen(768.0, 1280.0),
            user1 = Position(100f, 100f)
        )
    }, onSet = {})
}