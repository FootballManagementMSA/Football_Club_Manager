package com.example.core.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class MainHomeStudentDataUiModel(
    val status: Int,
    val code: String,
    val message: String,
    val data: StudentUiModel
)

data class Data(
    @SerializedName("student") val student: StudentUiModel,
    @SerializedName("schedule") val schedule: Schedule2
)

data class StudentUiModel(
    val name: String,
    val game: Int,
    val goal: Int,
    val position: String,
    val foot: String
)

data class Schedule2(
    val place: String,
    val startTime: LocalDateTime,
    @SerializedName("HomeTeam") val homeTeam: Team,
    @SerializedName("AwayTeam") val awayTeam: Team
)

data class Team(
    val name: String,
    val emblem: String
)
