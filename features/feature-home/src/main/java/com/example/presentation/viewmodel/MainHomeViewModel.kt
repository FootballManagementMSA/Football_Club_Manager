package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.LoadStudentDataUseCase
import com.example.presentation.StudentDataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainHomeViewModel @Inject constructor(
    private val loadStudentDataUseCase: LoadStudentDataUseCase
): ViewModel() {
    private val tempDispatcher = Dispatchers.IO
    private val _uiState = MutableStateFlow<StudentDataState>(StudentDataState.Loading)
    val uiState get() = _uiState.asStateFlow()

    fun getResponse() = viewModelScope.launch(tempDispatcher) {
        _uiState.value = StudentDataState.Success(loadStudentDataUseCase())
    }
}