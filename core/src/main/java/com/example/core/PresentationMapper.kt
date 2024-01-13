package com.example.core

import com.example.core.model.Position
import com.example.core.model.Screen
import com.example.core.model.TestUiModel
import com.example.network_api.model.PositionPreset
import com.example.network_api.model.TestResponse

object PresentationMapper {
    fun mapToUiPreset(positionPreset: PositionPreset) =
        com.example.core.model.PositionPreset(
            screenSize = DataMapper.mapToDataModel(positionPreset.screenSize),
            user1 = DataMapper.mapToDataModel2(positionPreset.user1)
        )
}

object DataMapper {

    fun mapToDataModel(screen: com.example.network_api.model.Screen) =
        Screen(screen.width, screen.height)

    fun mapToDataModel2(position: com.example.network_api.model.Position) =
        Position(position.x, position.y)
}
