package com.example.network_api.repository

import com.example.network_api.api.MainHomeApi
import com.example.network_api.response.MainHomeResponse
import retrofit2.Response
import javax.inject.Inject

class MainHomeRepositoryImpl @Inject constructor(
    private val mainHomeApi: MainHomeApi
) : MainHomeRepository {
    override suspend fun loadData(): MainHomeResponse {
        val result = mainHomeApi.loadData()
        return result.body()!!
    }
}