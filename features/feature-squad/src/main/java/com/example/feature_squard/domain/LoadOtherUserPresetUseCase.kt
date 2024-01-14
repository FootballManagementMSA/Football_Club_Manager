package com.example.feature_squard.domain

import com.example.core.datasource.PositionPresetDataSource
import com.example.core.model.LocalScreen
import com.example.core.model.PositionPresetUIModel
import com.example.core.model.PositionUiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoadOtherUserPresetUseCase @Inject constructor(
    private val localScreen: LocalScreen,
    private val positionPresetDataSource: PositionPresetDataSource
) {

    suspend operator fun invoke(): PositionPresetUIModel {
        val preset = positionPresetDataSource.loadOtherUserPreset()
        return preset.copy(
            memberPosition = preset.memberPosition.map { position ->
                PositionUiModel(
                    x = position.x * (localScreen.width / preset.screenSize.width).toFloat(),
                    y = position.y * (localScreen.height / preset.screenSize.height).toFloat()
                )
            }
        )
    }
}