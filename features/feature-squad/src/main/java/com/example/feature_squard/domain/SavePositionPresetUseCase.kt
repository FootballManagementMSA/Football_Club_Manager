package com.example.feature_squard.domain

import com.example.core.datasource.PositionPresetDataSource
import com.example.core.model.Position
import javax.inject.Inject

class SavePositionPresetUseCase @Inject constructor(
    private val positionPresetDataSource: PositionPresetDataSource
) {
    suspend operator fun invoke(position: Position) = positionPresetDataSource.save(position)
}