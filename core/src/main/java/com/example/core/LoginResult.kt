package com.example.core

sealed class LoginResult {
    data class Success(val accessToken: String, val refreshToken: String) : LoginResult()
    data class Error(val errorMessage: String) : LoginResult()
}