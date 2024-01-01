package com.example.network.repository

import com.example.network.network.TestApi
import com.example.network_api.model.TestResponse
import com.example.network_api.repository.TestRepository
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(private val testApi: TestApi) : TestRepository {
    override suspend fun getTestResponse(): TestResponse = testApi.getResponse()

}