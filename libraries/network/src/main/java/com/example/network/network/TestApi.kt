package com.example.network.network

import com.example.network_api.model.TestResponse

interface TestApi {
    suspend fun getResponse() : TestResponse
}