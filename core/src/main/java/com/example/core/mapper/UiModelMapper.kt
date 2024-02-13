package com.example.core.mapper

import com.example.core.mapper.EntityMapper.mapToEntity
import com.example.core.model.LocalScreen
import com.example.core.model.PositionPresetUIModel
import com.example.core.model.MemberUiModel
import com.example.core.model.Position
import com.example.network_api.entity.Member
import com.example.network_api.entity.PositionPreset
import com.example.network_api.entity.RemoteScreen

object UiModelMapper {
    fun PositionPreset.mapToUiModel() =
        PositionPresetUIModel(
            screenSize = this.screenSize.mapToUiModel(),
            members = this.members.map { it.mapToUiModel() }
        )

    fun RemoteScreen.mapToUiModel() =
        LocalScreen(this.width, this.height)

    fun com.example.network_api.entity.Position.mapToUiModel() = Position(
        x = this.x,
        y = this.y
    )

    fun Member.mapToUiModel() = MemberUiModel(
        id = this.id,
        name = this.name,
        role = this.role,
        number = this.number,
        position = this.position.mapToUiModel()
    )
}
