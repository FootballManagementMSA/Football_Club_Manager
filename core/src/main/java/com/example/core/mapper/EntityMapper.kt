package com.example.core.mapper

import com.example.core.mapper.EntityMapper.mapToEntity
import com.example.core.model.LocalScreen
import com.example.core.model.PositionPresetUIModel
import com.example.core.model.MemberUiModel
import com.example.core.model.Position
import com.example.network_api.entity.Member
import com.example.network_api.entity.PositionPreset
import com.example.network_api.entity.RemoteScreen

object EntityMapper {
    fun PositionPresetUIModel.mapToEntity() =
        PositionPreset(
            screenSize = this.screenSize.mapToEntity(),
            members = this.members.map { it.mapToEntity() }
        )

    fun MemberUiModel.mapToEntity() = Member(
        id = this.id,
        name = this.name,
        role = this.role,
        number = this.number,
        position = this.position.mapToEntity()
    )

    fun Position.mapToEntity() = com.example.network_api.entity.Position(
        x = this.x,
        y = this.y
    )

    fun LocalScreen.mapToEntity() = RemoteScreen(this.width, this.height)
}