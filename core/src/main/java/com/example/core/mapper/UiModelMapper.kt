package com.example.core.mapper

import com.example.core.model.LocalScreen
import com.example.core.model.PositionPresetUIModel
import com.example.core.model.PositionUiModel
import com.example.network_api.entity.Position
import com.example.network_api.entity.PositionPreset
import com.example.network_api.entity.RemoteScreen

object UiModelMapper {
    fun PositionPreset.mapToUiModel() =
        PositionPresetUIModel(
            screenSize = this.screenSize.mapToUiModel(),
            memberPosition = this.memberPosition.map { it.mapToUiModel() }
        )

    fun RemoteScreen.mapToUiModel() =
        LocalScreen(this.width, this.height)

    fun Position.mapToUiModel() = PositionUiModel(this.x, this.y)
}
