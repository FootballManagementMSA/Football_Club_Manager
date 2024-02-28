package com.example.core.datasource

import com.example.core.model.MainHomeUiModel
import com.example.network_api.response.MainHomeResponse

interface MainHomeDataSource {
    suspend fun loadData() : MainHomeUiModel
}