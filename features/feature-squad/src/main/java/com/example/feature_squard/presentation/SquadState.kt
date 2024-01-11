package com.example.feature_squard.presentation

import com.example.core.model.PositionPreset

sealed class SquadState {

    data object Loading : SquadState()

    data class Success(val data: PositionPreset) : SquadState()
}