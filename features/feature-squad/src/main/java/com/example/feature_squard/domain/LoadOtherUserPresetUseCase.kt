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
class LoadOtherUserPresetUseCase @Inject constructor(
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

    suspend operator fun invoke(): Position {
        val preset = positionPresetDataSource.loadOtherUserPreset()
        val otherUserScreenSize = preset.screenSize
        return Position(
            x = preset.user1.x * (localScreen.width / otherUserScreenSize.width).toFloat(),
            y = preset.user1.y * (localScreen.height / otherUserScreenSize.height).toFloat()
        )
    }
}