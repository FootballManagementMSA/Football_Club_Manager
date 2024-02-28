package com.example.network_api.api

import com.example.network_api.response.MainHomeResponse
import retrofit2.Response
import retrofit2.http.GET

interface MainHomeApi {

    @GET("/api/user-service/main")
    suspend fun loadData(): Response<MainHomeResponse>
}