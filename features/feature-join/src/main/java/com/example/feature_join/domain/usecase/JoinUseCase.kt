package com.example.feature_join.domain.usecase

import com.example.core.datasource.UserLocalDataSource
import javax.inject.Inject

class JoinUseCase @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource
) {
    suspend operator fun invoke() = userLocalDataSource.join()
}