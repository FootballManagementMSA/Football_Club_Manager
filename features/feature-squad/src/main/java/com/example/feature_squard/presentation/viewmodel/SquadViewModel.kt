package com.example.feature_squard.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_squard.domain.LoadPositionPresetUseCase
import com.example.feature_squard.domain.SavePositionPresetUseCase
import com.example.core.model.Position
import com.example.feature_squard.presentation.SquadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SquadViewModel @Inject constructor(
    private val loadPositionPresetUseCase: LoadPositionPresetUseCase,
    private val savePositionPresetUseCase: SavePositionPresetUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<SquadState>(SquadState.Loading)
    val uiState get() = _uiState

    fun loadPreset() = viewModelScope.launch {
        Log.e("123","${loadPositionPresetUseCase()}")
        _uiState.value = SquadState.Success(loadPositionPresetUseCase())
    }

    fun savePosition(position: Position) = viewModelScope.launch {
        savePositionPresetUseCase(position)
        Log.e("123","${loadPositionPresetUseCase()}")
    }
}