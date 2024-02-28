package com.example.network_api.repository

import com.example.network_api.response.MainHomeResponse
import retrofit2.Response

interface MainHomeRepository {
    suspend fun loadData(): MainHomeResponse
}