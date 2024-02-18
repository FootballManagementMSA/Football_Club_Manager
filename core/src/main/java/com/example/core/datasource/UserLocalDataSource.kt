package com.example.core.datasource

interface UserLocalDataSource {
    suspend fun saveAccessToken(accessToken: String)
    suspend fun saveAccount(account: String)
    suspend fun savePassword(password: String)
    suspend fun saveRefreshToken(refreshToken: String)
    suspend fun login()
    suspend fun join()
}