package com.example.network.repository

import android.util.Log
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
    private val tempPositionStore = MutableStateFlow<List<Position>>(listOf())

    init {
        repeat(11) {
            val updatedList = generateUniquePosition(tempPositionStore.value)
            tempPositionStore.value = updatedList
        }
        Log.e("positions","${tempPositionStore.value}")
    }

    //스크린 크기는 nexus 4 임시로 설정
    override suspend fun loadMyCustomSquadPreset(): PositionPreset {
        return PositionPreset(
            screenSize = screen, //기기 변동이 있을 경우를 대비하여 DB에 저장된 스크린 사이즈 필요
            memberPosition = tempPositionStore.value
        )
    }

    override suspend fun loadOtherUserCustomSquadPreset(): PositionPreset {
        return PositionPreset(screenSize = Screen(768.0, 1280.0), memberPosition = tempPositionStore.value)
    }

    override suspend fun saveMyCustomSquadPreset(screen: Screen, positions: List<Position>) {
        tempPositionStore.value = positions
    }

    private fun generateUniquePosition(existingList: List<Position>): List<Position> {
        val newList = existingList.toMutableList()

        var newPosition: Position
        do {
            newPosition = createRandomPosition()
        } while (newList.contains(newPosition))

        newList.add(newPosition)
        return newList.toList()
    }

    // 랜덤한 Position 객체를 생성하는 함수 (실제 코드로 대체해야 함)
    private fun createRandomPosition(): Position {
        val randomX = (0..768).random().toFloat()
        val randomY = (0..1280).random().toFloat()
        return Position(randomX, randomY)
    }
}