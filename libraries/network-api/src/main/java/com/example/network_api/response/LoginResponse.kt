package com.example.network_api.response

data class LoginResponse(
    val status: Int,
    val message: String,
    val data: Token
)
data class Token(
    val accessToken: String,
    val refreshToken: String
)