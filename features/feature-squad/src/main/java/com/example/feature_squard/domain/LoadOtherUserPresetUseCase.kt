package com.example.feature_squard.domain

import com.example.core.datasource.PositionPresetDataSource
import com.example.core.model.LocalScreen
import com.example.core.model.PositionPresetUIModel
import com.example.core.model.PositionUiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoadOtherUserPresetUseCase @Inject constructor(
    private val myScreen: LocalScreen,
    private val positionPresetDataSource: PositionPresetDataSource
) {

    suspend operator fun invoke(): PositionPresetUIModel {
        val preset = positionPresetDataSource.loadOtherUserPreset()
        val otherUserScreen = preset.screenSize
        return preset.copy(
            memberPosition = preset.memberPosition.map { position ->
                PositionUiModel(
                    x = position.x * (myScreen.width / otherUserScreen.width).toFloat(),
                    y = position.y * (myScreen.height / otherUserScreen.height).toFloat()
                )
            }
        )
    }
}