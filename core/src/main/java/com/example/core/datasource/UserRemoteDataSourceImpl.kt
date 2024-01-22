package com.example.core.datasource

import com.example.core.model.UserInfo
import javax.inject.Inject

internal class UserRemoteDataSourceImpl @Inject constructor(
) : UserRemoteDataSource {
    override suspend fun login() {
    }

    override suspend fun sendClubInfoData() {
    }

    override suspend fun getJoinClubUserInfo(): List<UserInfo> {
        return listOf(UserInfo("13", "3", "st", "erer"))
    }
}