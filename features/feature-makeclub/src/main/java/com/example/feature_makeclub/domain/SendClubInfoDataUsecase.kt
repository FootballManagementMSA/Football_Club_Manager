package com.example.feature_makeclub.domain

import com.example.core.datasource.UserRemoteDataSource
import javax.inject.Inject

class SendClubInfoDataUseCase @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) {
    suspend operator fun invoke() = userRemoteDataSource.sendClubInfoData()
}