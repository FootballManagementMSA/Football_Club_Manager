package com.example.feature_login.domain.usecase

import com.example.core.datasource.UserRemoteDataSource
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) {
    suspend operator fun invoke() = userRemoteDataSource.login()
}