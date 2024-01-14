package com.example.feature_squard.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.model.PositionUiModel
import com.example.feature_squard.domain.LoadMyPresetUseCase
import com.example.feature_squard.domain.SavePositionPresetUseCase
import com.example.feature_squard.presentation.SquadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SquadViewModel @Inject constructor(
    private val loadMyPresetUseCase: LoadMyPresetUseCase,
    private val savePositionPresetUseCase: SavePositionPresetUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<SquadState>(SquadState.Loading)
    val uiState get() = _uiState

    fun loadPreset() = viewModelScope.launch {
        _uiState.value = SquadState.Success(loadMyPresetUseCase())
    }

    fun savePosition(positions: List<PositionUiModel>) = viewModelScope.launch {
        savePositionPresetUseCase(positions)
    }
}