package com.example.network.repository

import com.example.network_api.model.Position
import com.example.network_api.model.PositionPreset
import com.example.network_api.model.Screen
import com.example.network_api.repository.TempSquadRepository

internal class TempSquadRepositoryImpl : TempSquadRepository {
    override suspend fun saveMyCustomSquadPreset(positionPreset: PositionPreset) {
        TODO("Not yet implemented")
    }

    override suspend fun loadMyCustomSquadPreset(): PositionPreset {
        return PositionPreset(user1 = Position(500f, 300f))
    }

    override suspend fun loadOtherUserCustomSquadPreset(): PositionPreset {
        return PositionPreset(screenSize = Screen(768.0, 1280.0), user1 = Position(400f, 400f))
    }
}