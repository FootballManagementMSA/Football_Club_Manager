package com.example.network_api.response

data class SearchClubResponse(
    val status: Int,
    val code: String,
    val message: String,
    val data: List<ClubInfoResponse>,
)

data class ClubInfoResponse(
    val id: String,
    val name: String,
    val memberNum: String,
    val star: Int
)
