package com.example.feature_squard.domain

import com.example.core.datasource.PositionPresetDataSource
import com.example.core.model.LocalScreen
import com.example.core.model.PositionPresetUIModel
import com.example.core.model.PositionUiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SavePositionPresetUseCase @Inject constructor(
    private val localScreen: LocalScreen,
    private val positionPresetDataSource: PositionPresetDataSource
) {

    suspend operator fun invoke(positions: List<PositionUiModel>) {
        positionPresetDataSource.save(
            positionPresetUIModel = PositionPresetUIModel(
                screenSize = localScreen,
                memberPosition = positions
            )
        )
    }
}