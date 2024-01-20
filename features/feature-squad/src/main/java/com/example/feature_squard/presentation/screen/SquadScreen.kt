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
import com.example.core.model.LocalScreen
import com.example.core.model.PositionPresetUIModel
import com.example.core.model.PositionUiModel
import com.example.feature_squard.presentation.SquadState
import com.example.feature_squard.presentation.ui_component.CandidateView
import com.example.feature_squard.presentation.ui_component.DraggableMember
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
private fun SquadContent(onLoad: () -> PositionPresetUIModel, onSet: (List<PositionUiModel>) -> Unit) {
    val positions = remember { onLoad().memberPosition.toMutableList() }

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
        positions.forEachIndexed { index, _ ->
            DraggableMember(memberNumber = index, onLoad) { newPosition ->
                positions[index] = newPosition
            }
        }
        Button(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = { onSet(positions) }) {
            Text(text = "save preset")
        }
    }
}

@Composable
@Preview
fun SquadContentPreview() {
    SquadContent(onLoad = {
        PositionPresetUIModel(
            screenSize = LocalScreen(768.0, 1280.0),
            memberPosition = listOf(PositionUiModel(100f, 100f))
        )
    }, onSet = {})
}