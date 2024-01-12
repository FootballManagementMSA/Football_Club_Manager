package com.example.core.datasource

import com.example.core.PresentationMapper
import com.example.core.model.TestUiModel
import com.example.network_api.repository.TestRepository
import javax.inject.Inject

internal class TestDataSourceImpl @Inject constructor(private val testRepository: TestRepository) :
    TestDataSource {
    override suspend fun getResponse(): TestUiModel = PresentationMapper.mapToUiModel(testRepository.getTestResponse())
}