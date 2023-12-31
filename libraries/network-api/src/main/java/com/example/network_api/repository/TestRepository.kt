package com.example.network_api.repository

import com.example.network_api.model.TestResponse

interface TestRepository {
    suspend fun getTestResponse() : TestResponse
}