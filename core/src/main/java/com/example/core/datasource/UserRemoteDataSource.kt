package com.example.core.datasource

interface UserRemoteDataSource {
    suspend fun login()
    suspend fun sendClubInfoData()
}