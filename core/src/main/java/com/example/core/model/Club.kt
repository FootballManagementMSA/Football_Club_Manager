package com.example.core.model

data class Club(
    val status: Int,
    val code: String,
    val message: String,
    val data: ClubData,
)

data class ClubData(
    val team: List<ClubInfo>
)

data class ClubInfo(
    val id: String,
    val name: String,
    val memberNum: String,
    val star: Int
)
