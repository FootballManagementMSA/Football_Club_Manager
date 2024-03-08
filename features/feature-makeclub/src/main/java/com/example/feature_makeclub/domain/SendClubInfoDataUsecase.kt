package com.example.feature_makeclub.domain

import com.example.core.ResultState.MakeClubResult
import com.example.core.datasource.ClubDataSource
import com.example.core.model.MakeClubModel
import javax.inject.Inject

class SendClubInfoDataUseCase @Inject constructor(
    private val clubDataSource: ClubDataSource
) {
    suspend operator fun invoke(makeClubModel: MakeClubModel): MakeClubResult {
        return clubDataSource.sendClubInfo(makeClubModel)
    }
}