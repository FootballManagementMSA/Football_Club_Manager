package com.example.network_api.repository

import com.example.network_api.entity.PositionPreset

interface TempSquadRepository {
    suspend fun loadMyCustomSquadPreset(): PositionPreset

    suspend fun loadOtherUserCustomSquadPreset(): PositionPreset

    suspend fun saveMyCustomSquadPreset(positionPreset: PositionPreset)
}