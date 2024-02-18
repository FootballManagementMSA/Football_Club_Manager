package com.example.core.datasource

import com.example.core.model.LoginModel
import com.example.core.model.UserInfo

interface UserRemoteDataSource {
    suspend fun login(loginModel: LoginModel)
    suspend fun sendClubInfoData()
    suspend fun getJoinClubUserInfo(): List<UserInfo>
}