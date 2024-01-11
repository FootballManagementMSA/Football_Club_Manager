package com.example.feature_squard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_squard.presentation.Position
import com.example.feature_squard.presentation.PositionPreset
import com.example.feature_squard.presentation.SquadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SquadViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<SquadState>(SquadState.Loading)
    val uiState get() = _uiState

    fun loadPreset() = viewModelScope.launch {
        _uiState.value = SquadState.Success(PositionPreset(Position(400f, 300f)))
    }

    fun savePosition(position : Position) = viewModelScope.launch {

    }
}