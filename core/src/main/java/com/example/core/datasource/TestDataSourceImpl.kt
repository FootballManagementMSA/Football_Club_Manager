package com.example.core.datasource

import com.example.core.TestMapper
import com.example.core.model.TestUiModel
import com.example.network_api.model.TestResponse
import com.example.network_api.repository.TestRepository
import javax.inject.Inject

internal class TestDataSourceImpl @Inject constructor(private val testRepository: TestRepository) :
    TestDataSource {
    override suspend fun getResponse(): TestUiModel = TestMapper.mapToUiModel(testRepository.getTestResponse())
}