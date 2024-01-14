package com.example.core.datasource

import com.example.core.model.PositionPresetUIModel

//임시 테스트용
interface PositionPresetDataSource {
    suspend fun save(positionPresetUIModel: PositionPresetUIModel)
    suspend fun loadMyPreset() : PositionPresetUIModel
    suspend fun loadOtherUserPreset() : PositionPresetUIModel
}