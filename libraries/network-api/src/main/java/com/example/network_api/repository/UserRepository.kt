package com.example.network_api.repository

import com.example.network_api.entity.Login
import com.example.network_api.response.LoginResponse
import com.example.network_api.response.RespResult
import com.example.network_api.response.UserInfoResponse

interface UserRepository {
    suspend fun login(loginReq: Login): RespResult<LoginResponse>
    suspend fun getUserInfo(): RespResult<UserInfoResponse>
}