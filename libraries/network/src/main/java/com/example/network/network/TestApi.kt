package com.example.network.network

import com.example.network_api.response.TestResponse

interface TestApi {
    suspend fun getResponse() : TestResponse
}