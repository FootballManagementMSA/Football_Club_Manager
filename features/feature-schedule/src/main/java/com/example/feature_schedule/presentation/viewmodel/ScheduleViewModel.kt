package com.example.feature_schedule.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.model.ClubSchedule
import com.example.feature_schedule.domain.usecase.MakeScheduleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val makeScheduleUseCase: MakeScheduleUseCase
) : ViewModel() {
    fun makeClub(teamId: Long, clubSchedule: ClubSchedule) = viewModelScope.launch {
        makeScheduleUseCase(teamId, clubSchedule)
    }
}