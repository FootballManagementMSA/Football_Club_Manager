package com.example.presentation

import com.example.core.model.StudentUiModel

sealed class StudentDataState {
    data class Success(val data: StudentUiModel) : StudentDataState()
    data object Loading : StudentDataState()
}
