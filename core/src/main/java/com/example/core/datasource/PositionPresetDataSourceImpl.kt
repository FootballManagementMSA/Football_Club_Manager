package com.example.core.datasource

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.WindowManager
import androidx.core.content.ContextCompat.getSystemService
import com.example.core.PresentationMapper
import com.example.core.model.Position
import com.example.core.model.Position.Companion.mapToDataModel
import com.example.core.model.PositionPreset
import com.example.core.model.Screen
import com.example.core.model.Screen.Companion.mapToDataModel
import com.example.network_api.repository.TempSquadRepository
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

//임시 테스트용
@Singleton
internal class PositionPresetDataSourceImpl @Inject constructor(private val tempSquadRepository: TempSquadRepository) :
    PositionPresetDataSource {

    override suspend fun save(localScreen: Screen, position: Position) {
        tempSquadRepository.saveMyCustomSquadPreset(
            position = position.mapToDataModel(), screen = localScreen.mapToDataModel()
        )
    }

    override suspend fun loadMyPreset(): PositionPreset {
        return PresentationMapper.mapToUiPreset(tempSquadRepository.loadMyCustomSquadPreset())
    }

    override suspend fun loadOtherUserPreset(): PositionPreset {
        return PresentationMapper.mapToUiPreset(tempSquadRepository.loadOtherUserCustomSquadPreset())
    }
}