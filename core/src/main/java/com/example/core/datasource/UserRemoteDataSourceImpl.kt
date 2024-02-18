package com.example.core.datasource

import com.example.core.model.LoginModel
import com.example.core.model.UserInfo
import javax.inject.Inject

internal class UserRemoteDataSourceImpl @Inject constructor(
) : UserRemoteDataSource {
    override suspend fun login(loginModel: LoginModel) {

    }

    override suspend fun sendClubInfoData() {
    }
    //레포지토리에서 가져오도록 수정
    override suspend fun getJoinClubUserInfo(): List<UserInfo> {
        return listOf(UserInfo("임성우","133333", "3", "st", "erer"), UserInfo("테스트","26","5","GK","안녕하세요 테스트입니다."))
    }
}