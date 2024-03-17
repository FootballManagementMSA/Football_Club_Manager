package com.example.core.datasource

import com.example.core.model.MainHomeStudentDataUiModel

interface MainHomeDataSource {
    suspend fun loadStudentData() : MainHomeStudentDataUiModel
}