package com.example.core.datasource

import com.example.core.LoginResult
import com.example.core.model.LoginModel
import com.example.core.model.MyPageUserInfoUiModel
import com.example.core.model.UserInfo

interface UserRemoteDataSource {
    suspend fun login(loginModel: LoginModel): LoginResult
    suspend fun sendClubInfoData()
    suspend fun getJoinClubUserInfo(): List<UserInfo>
    suspend fun getUserInfo(): MyPageUserInfoUiModel
}