package com.example.feature_squard.presentation

sealed class SquadState {

    data object Loading : SquadState()

    data class Success(val data: PositionPreset) : SquadState()
}