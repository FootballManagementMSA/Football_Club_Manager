package com.example.network.network

import com.example.network_api.model.TestResponse

// 순수 더미 클래스
class TestApiImpl : TestApi {
    override suspend fun getResponse(): TestResponse = TestResponse("Http 200")
}