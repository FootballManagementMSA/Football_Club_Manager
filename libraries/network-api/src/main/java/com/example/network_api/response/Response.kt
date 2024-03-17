package com.example.network_api.response

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class MainHomeStudentDataResponse(
    val status: Int,
    val code: String,
    val message: String,
    val data: Student
)

data class Data(
    @SerializedName("student") val student: Student,
    @SerializedName("schedule") val schedule: Schedule
)

data class Student(
    val name: String,
    val game: Int,
    val goal: Int,
    val position: String,
    val foot: String
)

data class Schedule(
    val place: String,
    val startTime: LocalDateTime,
    @SerializedName("HomeTeam") val homeTeam: Team,
    @SerializedName("AwayTeam") val awayTeam: Team
)

data class Team(
    val name: String,
    val emblem: String
)