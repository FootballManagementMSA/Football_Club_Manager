package com.example.core.datasource

import com.example.core.model.TestUiModel

interface TestDataSource {
    suspend fun getResponse() : TestUiModel
}