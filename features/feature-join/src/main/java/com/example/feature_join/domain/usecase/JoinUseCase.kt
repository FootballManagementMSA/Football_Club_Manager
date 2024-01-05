package com.example.feature_join.domain.usecase

import com.example.core.datasource.UserDataSource
import javax.inject.Inject

class JoinUseCase @Inject constructor(
    private val userDataSource: UserDataSource
) {
    suspend operator fun invoke() = userDataSource.join()
}