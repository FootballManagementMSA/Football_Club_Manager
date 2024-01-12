package com.example.core.datasource

import android.content.Context
import android.os.Build
import android.util.Log
import android.view.WindowManager
import androidx.core.content.ContextCompat.getSystemService
import com.example.core.model.Position
import com.example.core.model.PositionPreset
import com.example.core.model.Screen
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

//임시 테스트용
@Singleton
class PositionPresetDataSourceImpl @Inject constructor(@ApplicationContext context: Context) :
    PositionPresetDataSource {
    private val localScreen = MutableStateFlow(Screen(0.0, 0.0))
    private val remoteScreen = MutableStateFlow(Screen(768.0, 1280.0)) // 상대의 휴대폰 화면 사이즈
    private val positionStore = MutableStateFlow(Position(400f, 400f))
    private val preset = MutableStateFlow<PositionPreset?>(null)

    init {
        val manager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val (w, h) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            manager.currentWindowMetrics.bounds.width() to manager.currentWindowMetrics.bounds.height()
        } else {
            manager.defaultDisplay.width to manager.defaultDisplay.height
        }
        localScreen.value = Screen(w.toDouble(), h.toDouble())
    }

    //나의 커스텀 프리셋을 저장할 때
    override suspend fun save(position: Position) {
        preset.value = PositionPreset(localScreen = localScreen.value, user1 = position)
    }

    //나 또는 상대의 커스텀 프리셋을 불러올 때
    override suspend fun load(): Position {
        val pos = Position(
            x = positionStore.value.x * (localScreen.value.width / remoteScreen.value.width).toFloat(),
            y = positionStore.value.y * (localScreen.value.height / remoteScreen.value.height).toFloat()
        )
        Log.e("pos", "$pos")
        return pos
    }
}