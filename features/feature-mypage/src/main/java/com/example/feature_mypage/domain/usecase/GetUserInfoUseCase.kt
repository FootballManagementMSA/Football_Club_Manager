package com.example.feature_mypage.domain.usecase

import com.example.core.datasource.UserRemoteDataSource
import com.example.core.model.MyPageUserInfoUiModel
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) {
    suspend operator fun invoke(): MyPageUserInfoUiModel {
        return userRemoteDataSource.getUserInfo()
    }
}