package com.example.feature_squard.domain

import com.example.core.datasource.PositionPresetDataSource
import com.example.core.model.LocalScreen
import com.example.core.model.PositionPresetUIModel
import com.example.core.model.PositionUiModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoadMyPresetUseCase @Inject constructor(
    private val localScreen: LocalScreen,
    private val positionPresetDataSource: PositionPresetDataSource
) {

    //자신의 폰에도 화면 비율을 구하는 이유는
    //만약 기종이 다른 폰으로 로그인 할 경우 화면의 크기가 달라지기 때문이다.
    suspend operator fun invoke(): PositionPresetUIModel {
        val preset = positionPresetDataSource.loadMyPreset()
        return preset.copy(
            memberPosition = preset.memberPosition.map { position ->
                PositionUiModel(
                    x = position.x * (localScreen.width / preset.screenSize.width).toFloat(),
                    y = position.y * (localScreen.height / preset.screenSize.height).toFloat()
                )
            }
        )
    }
}