package com.example.feature_login.domain.usecase

import com.example.core.datasource.UserDataSource
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userDataSource: UserDataSource
) {
    suspend operator fun invoke() = userDataSource.login()
}