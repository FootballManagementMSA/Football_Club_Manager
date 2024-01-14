package com.example.feature_squard.domain

import com.example.core.datasource.PositionPresetDataSource
import com.example.core.model.Position
import com.example.core.model.Screen
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SavePositionPresetUseCase @Inject constructor(
    private val localScreen: Screen,
    private val positionPresetDataSource: PositionPresetDataSource
) {

    suspend operator fun invoke(positions: List<Position>) {
        positionPresetDataSource.save(positions = positions, localScreen = localScreen)
    }
}