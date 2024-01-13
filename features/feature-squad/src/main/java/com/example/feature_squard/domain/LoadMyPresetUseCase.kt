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
class LoadMyPresetUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val positionPresetDataSource: PositionPresetDataSource
) {
    private var localScreen = Screen(0.0, 0.0)

    init {
        val manager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val (w, h) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            manager.currentWindowMetrics.bounds.width() to manager.currentWindowMetrics.bounds.height()
        } else {
            manager.defaultDisplay.width to manager.defaultDisplay.height
        }
        localScreen = Screen(w.toDouble(), h.toDouble())
    }

    //자신의 폰에도 화면 비율을 구하는 이유는
    //만약 기종이 다른 폰으로 로그인 할 경우 화면의 크기가 달라지기 때문이다.
    suspend operator fun invoke(): Position {
        val preset = positionPresetDataSource.loadMyPreset()
        val myScreenSize = preset.screenSize
        return Position(
            x = preset.user1.x * (localScreen.width / myScreenSize.width).toFloat(),
            y = preset.user1.y * (localScreen.height / myScreenSize.height).toFloat()
        )
    }
}