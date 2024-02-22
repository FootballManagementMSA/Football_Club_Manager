package com.example.network.repository

import com.example.network_api.ErrorType
import com.example.network_api.RespMapper
import com.example.network_api.api.FootballManagerApi
import com.example.network_api.entity.Login
import com.example.network_api.repository.UserRepository
import com.example.network_api.response.LoginResponse
import com.example.network_api.response.RespResult
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    private val footballManagerApi: FootballManagerApi
): UserRepository{
    override suspend fun login(loginReq: Login): RespResult<LoginResponse> {
        val response = footballManagerApi.login(loginReq)

        return if (response.isSuccessful) {
            RespResult.Success(response.body()!!)
        } else {
            val errorBodyJson = response.errorBody()?.string() ?: ""
            val errorBody = RespMapper.errorMapper(errorBodyJson)
            RespResult.Error(ErrorType(errorBody.message!!, errorBody.code))
        }
    }
}