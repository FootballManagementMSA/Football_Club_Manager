package com.example.core.datasource

import com.example.core.model.Position
import com.example.core.model.PositionPreset
import com.example.core.model.Screen

//임시 테스트용
interface PositionPresetDataSource {
    suspend fun save(localScreen: Screen, position: Position)
    suspend fun loadMyPreset() : PositionPreset

    suspend fun loadOtherUserPreset() : PositionPreset
}