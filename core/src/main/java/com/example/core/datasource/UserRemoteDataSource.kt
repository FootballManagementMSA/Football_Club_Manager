package com.example.core.datasource

import com.example.core.model.UserInfo

interface UserRemoteDataSource {
    suspend fun login()
    suspend fun sendClubInfoData()
    suspend fun getJoinClubUserInfo(): List<UserInfo>
}