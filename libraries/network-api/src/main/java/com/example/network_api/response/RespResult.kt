package com.example.network_api.response

sealed class RespResult<T> {
    data class Success<T>(val data: T) : RespResult<T>()
    data class Error<T>(val error: String) : RespResult<T>()
}
