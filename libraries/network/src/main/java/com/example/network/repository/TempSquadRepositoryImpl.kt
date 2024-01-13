package com.example.network.repository

import com.example.network_api.model.Position
import com.example.network_api.model.PositionPreset
import com.example.network_api.model.Screen
import com.example.network_api.repository.TempSquadRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

//추후 API로 대체
internal class TempSquadRepositoryImpl @Inject constructor(
    private val screen: Screen
) : TempSquadRepository {
    private val tempPositionStore = MutableStateFlow(Position(500f, 300f))

    //스크린 크기는 nexus 4 임시로 설정
    override suspend fun loadMyCustomSquadPreset(): PositionPreset {
        return PositionPreset(
            screenSize = screen, //기기 변동이 있을 경우를 대비하여 DB에 저장된 스크린 사이즈 필요
            user1 = Position(tempPositionStore.value.x, tempPositionStore.value.y)
        )
    }

    override suspend fun loadOtherUserCustomSquadPreset(): PositionPreset {
        return PositionPreset(screenSize = Screen(768.0, 1280.0), user1 = Position(400f, 400f))
    }

    override suspend fun saveMyCustomSquadPreset(screen: Screen, position: Position) {
        tempPositionStore.value = position
    }
}