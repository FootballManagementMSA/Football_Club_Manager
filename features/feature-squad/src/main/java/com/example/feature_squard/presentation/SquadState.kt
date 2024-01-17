package com.example.feature_squard.presentation

import com.example.core.model.PositionPresetUIModel

sealed class SquadState {

    data object Loading : SquadState()

    data class Success(val data: PositionPresetUIModel) : SquadState()
}