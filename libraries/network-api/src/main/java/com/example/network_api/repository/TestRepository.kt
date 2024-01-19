package com.example.network_api.repository

import com.example.network_api.response.TestResponse

interface TestRepository {
    suspend fun getTestResponse() : TestResponse
}