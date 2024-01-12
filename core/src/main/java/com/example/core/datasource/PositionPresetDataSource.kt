package com.example.core.datasource

import com.example.core.model.Position
import com.example.core.model.PositionPreset

//임시 테스트용
interface PositionPresetDataSource {
    suspend fun save(position: Position)
    suspend fun load() : Position
}