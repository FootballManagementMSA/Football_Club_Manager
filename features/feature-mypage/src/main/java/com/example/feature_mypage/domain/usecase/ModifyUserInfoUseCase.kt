package com.example.feature_mypage.domain.usecase

import com.example.core.ResultState.BaseResult
import com.example.core.datasource.UserRemoteDataSource
import com.example.core.model.ModifyUserInfoModel
import javax.inject.Inject

class ModifyUserInfoUseCase @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) {
    suspend operator fun invoke(modifyUserInfoModel: ModifyUserInfoModel): BaseResult {
        return userRemoteDataSource.modifyUserInfo(modifyUserInfoModel)
    }
}