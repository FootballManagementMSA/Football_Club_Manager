package com.example.core

sealed class JoinResult {
    data class Error(val errorMessage: String) : JoinResult()
    data class Success(val some:String) : JoinResult()

}
