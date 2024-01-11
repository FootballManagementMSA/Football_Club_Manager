package com.example.feature_squard.domain

import com.example.core.datasource.PositionPresetDataSource
import com.example.core.model.Position
import com.example.core.model.PositionPreset
import javax.inject.Inject

class LoadPositionPresetUseCase @Inject constructor(
    private val positionPresetDataSource: PositionPresetDataSource
) {
    suspend operator fun invoke() = positionPresetDataSource.load()
}