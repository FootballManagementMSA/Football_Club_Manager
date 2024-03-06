package com.example.feature_join.domain.usecase

import com.example.core.JoinResult
import com.example.core.datasource.UserLocalDataSource
import com.example.core.datasource.UserRemoteDataSource
import com.example.core.model.JoinModel
import com.example.core.model.LoginModel
import javax.inject.Inject

class JoinUseCase @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) {
    suspend operator fun invoke(joinModel: JoinModel) :JoinResult{
        return userRemoteDataSource.join(joinModel)
    }
}
