package com.example.core.datasource

import javax.inject.Inject

internal class UserRemoteDataSourceImpl @Inject constructor(
): UserRemoteDataSource {
    override suspend fun login() {
    }

    override suspend fun sendClubInfoData() {
    }
}