package com.example.feature_mypage.domain.usecase

import com.example.core.datasource.UserLocalDataSource
import javax.inject.Inject

class ClearDataStoreUseCase @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource
) {
    suspend operator fun invoke() = userLocalDataSource.clearDataStore()
}