package com.example.feature_squard.domain

import android.content.Context
import android.os.Build
import android.view.WindowManager
import com.example.core.datasource.PositionPresetDataSource
import com.example.core.model.Position
import com.example.core.model.Screen
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SavePositionPresetUseCase @Inject constructor(
    private val localScreen: Screen,
    private val positionPresetDataSource: PositionPresetDataSource
) {

    suspend operator fun invoke(position: Position) {
        positionPresetDataSource.save(position = position, localScreen = localScreen)
    }
}