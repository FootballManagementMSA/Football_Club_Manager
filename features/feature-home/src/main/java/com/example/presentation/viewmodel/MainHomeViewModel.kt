package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainHomeViewModel @Inject constructor(

): ViewModel() {
    private val tempDispatcher = Dispatchers.IO
    private val _uiState = MutableStateFlow("")
    val uiState get() = _uiState.asStateFlow()
    fun getResponse() = viewModelScope.launch(tempDispatcher) {
        _uiState.value = ""
    }
}