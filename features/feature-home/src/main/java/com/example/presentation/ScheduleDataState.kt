package com.example.presentation

import com.example.core.model.MainSchedule

sealed class ScheduleDataState {
    data class Success(val data: List<MainSchedule?>) : ScheduleDataState()
    data object Loading : ScheduleDataState()
}
