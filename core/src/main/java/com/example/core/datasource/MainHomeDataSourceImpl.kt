package com.example.core.datasource

import com.example.core.mapper.UiModelMapper.mapToUiModel
import com.example.core.model.MainHomeUiModel
import com.example.network_api.repository.MainHomeRepository
import com.example.network_api.response.MainHomeResponse
import javax.inject.Inject

class MainHomeDataSourceImpl @Inject constructor(
    private val mainHomeRepository: MainHomeRepository
) : MainHomeDataSource {
    override suspend fun loadData(): MainHomeUiModel {
        return mainHomeRepository.loadData().mapToUiModel()
    }
}