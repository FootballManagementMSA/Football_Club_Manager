package com.example.feature_squard.domain

import com.example.core.datasource.PositionPresetDataSource
import com.example.core.model.Position
import com.example.core.model.PositionPreset
import com.example.core.model.Screen
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoadOtherUserPresetUseCase @Inject constructor(
    private val localScreen: Screen,
    private val positionPresetDataSource: PositionPresetDataSource
) {

    suspend operator fun invoke(): PositionPreset {
        val preset = positionPresetDataSource.loadOtherUserPreset()
        return preset.copy(
            memberPosition = preset.memberPosition.map { position ->
                Position(
                    x = position.x * (localScreen.width / preset.screenSize.width).toFloat(),
                    y = position.y * (localScreen.height / preset.screenSize.height).toFloat()
                )
            }
        )
    }
}