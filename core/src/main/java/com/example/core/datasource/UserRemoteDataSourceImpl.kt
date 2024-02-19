package com.example.core.datasource

import com.example.core.LoginResult
import com.example.core.mapper.EntityMapper.mapToEntity
import com.example.core.model.LoginModel
import com.example.core.model.UserInfo
import com.example.network_api.repository.UserRepository
import com.example.network_api.response.RespResult
import javax.inject.Inject

internal class UserRemoteDataSourceImpl @Inject constructor(
    private val userRepository: UserRepository,
    private val userLocalDataSource: UserLocalDataSource
) : UserRemoteDataSource {
    override suspend fun login(loginModel: LoginModel): LoginResult {
        val result = userRepository.login(loginModel.mapToEntity())
        return when (result) {
            is RespResult.Success -> {
                with(userLocalDataSource) {
                    saveAccessToken(result.data.data.accessToken)
                    saveAccessToken(result.data.data.refreshToken)
                    saveAccount(loginModel.id)
                    savePassword(loginModel.pw)
                }
                LoginResult.Success(result.data.data.accessToken, result.data.data.refreshToken)
            }
            is RespResult.Error -> {
                LoginResult.Error(result.error.errorMessage)
            }
        }
    }

    override suspend fun sendClubInfoData() {
    }
    //레포지토리에서 가져오도록 수정
    override suspend fun getJoinClubUserInfo(): List<UserInfo> {
        return listOf(UserInfo("임성우","133333", "3", "st", "erer"), UserInfo("테스트","26","5","GK","안녕하세요 테스트입니다."))
    }
}
