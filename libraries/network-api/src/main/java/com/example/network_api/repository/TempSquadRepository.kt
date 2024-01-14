package com.example.network_api.repository

import com.example.network_api.model.Position
import com.example.network_api.model.PositionPreset
import com.example.network_api.model.Screen

interface TempSquadRepository {
    suspend fun loadMyCustomSquadPreset(): PositionPreset

    suspend fun loadOtherUserCustomSquadPreset(): PositionPreset

    suspend fun saveMyCustomSquadPreset(screen: Screen, positions: List<Position>)
}