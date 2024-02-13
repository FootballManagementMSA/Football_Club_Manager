package com.example.feature_dialog.domain

import com.example.core.datasource.UserRemoteDataSource
import com.example.core.model.UserInfo
import javax.inject.Inject

class GetJoinClubUserInfoUseCase @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) {
    suspend operator fun invoke(): List<UserInfo>{
        return userRemoteDataSource.getJoinClubUserInfo()
    }
}