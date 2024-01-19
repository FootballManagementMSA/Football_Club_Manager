package com.example.core.mapper

import com.example.core.model.LocalScreen
import com.example.core.model.PositionPresetUIModel
import com.example.core.model.PositionUiModel
import com.example.network_api.entity.Position
import com.example.network_api.entity.PositionPreset
import com.example.network_api.entity.RemoteScreen

object EntityMapper {
    fun PositionPresetUIModel.mapToEntity() =
        PositionPreset(
            screenSize = this.screenSize.mapToEntity(),
            memberPosition = this.memberPosition.map { it.mapToEntity() }
        )

    fun PositionUiModel.mapToEntity() = Position(this.x, this.y)

    fun LocalScreen.mapToEntity() = RemoteScreen(this.width, this.height)
}