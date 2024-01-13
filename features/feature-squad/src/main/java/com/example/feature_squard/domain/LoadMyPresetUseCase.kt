package com.example.feature_squard.domain

import com.example.core.datasource.PositionPresetDataSource
import com.example.core.model.Position
import com.example.core.model.PositionPreset
import com.example.core.model.Screen
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoadMyPresetUseCase @Inject constructor(
    private val localScreen: Screen,
    private val positionPresetDataSource: PositionPresetDataSource
) {

    //자신의 폰에도 화면 비율을 구하는 이유는
    //만약 기종이 다른 폰으로 로그인 할 경우 화면의 크기가 달라지기 때문이다.
    suspend operator fun invoke(): PositionPreset {
        val preset = positionPresetDataSource.loadMyPreset()
        return preset.copy(
            user1 = Position(
                x = preset.user1.x * (localScreen.width / preset.screenSize.width).toFloat(),
                y = preset.user1.y * (localScreen.height / preset.screenSize.height).toFloat()
            )
        )
    }
}