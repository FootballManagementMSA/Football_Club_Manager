package com.example.network_api.api

import com.example.network_api.entity.Login
import com.example.network_api.response.LoginResponse
import com.example.network_api.response.UserInfoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FootballManagerApi {
    @POST("/api/user-service/login")
    suspend fun login(
        @Body loginReq: Login
    ): Response<LoginResponse>

    @GET("/api/user-service/users")
    suspend fun getUserInfo(): Response<UserInfoResponse>
}