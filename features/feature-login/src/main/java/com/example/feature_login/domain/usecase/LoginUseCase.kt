package com.example.feature_login.domain.usecase

import com.example.core.LoginResult
import com.example.core.datasource.UserRemoteDataSource
import com.example.core.model.LoginModel
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) {
    suspend operator fun invoke(loginModel: LoginModel): LoginResult {
        return userRemoteDataSource.login(loginModel)
    }
}