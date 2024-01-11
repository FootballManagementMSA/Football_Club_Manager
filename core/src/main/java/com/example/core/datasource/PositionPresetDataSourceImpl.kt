package com.example.core.datasource

import com.example.core.model.Position
import com.example.core.model.PositionPreset
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

//임시 테스트용
@Singleton
class PositionPresetDataSourceImpl @Inject constructor() : PositionPresetDataSource {
    private val positionStore = MutableStateFlow(PositionPreset(Position(0.5f,0.5f)))
    override suspend fun save(position: Position) {
        positionStore.value = PositionPreset(position)
    }

    override suspend fun load(): PositionPreset {
        return positionStore.value
    }
}