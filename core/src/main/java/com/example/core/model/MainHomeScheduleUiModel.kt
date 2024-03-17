package com.example.core.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class MainHomeScheduleUiModel(
    val status: Int,
    val code: String,
    val message: String,
    val data: ScheduleData
)

data class ScheduleData(
    val schedule: MainSchedule
)
data class MainSchedule(
    val place: String,
    val startTime: LocalDateTime,
    @SerializedName("HomeTeam") val homeTeam: Team,
    @SerializedName("AwayTeam") val awayTeam: Team
)

data class Team(
    val name: String,
    val emblem: String
)