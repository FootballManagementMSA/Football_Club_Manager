package com.example.network.repository

import com.example.network.network.TestApi
import com.example.network_api.repository.TestRepository
import com.example.network_api.response.TestResponse
import javax.inject.Inject

internal class TestRepositoryImpl @Inject constructor(private val testApi: TestApi) : TestRepository {
    override suspend fun getTestResponse(): TestResponse = testApi.getResponse()

}