package com.example.core.datasource

import com.example.core.mapper.UiModelMapper.mapToUiModel
import com.example.core.model.MainHomeStudentDataUiModel
import com.example.network_api.repository.MainHomeRepository
import javax.inject.Inject

class MainHomeDataSourceImpl @Inject constructor(
    private val mainHomeRepository: MainHomeRepository
) : MainHomeDataSource {
    override suspend fun loadStudentData(): MainHomeStudentDataUiModel {
        return mainHomeRepository.loadData().mapToUiModel()
    }
}