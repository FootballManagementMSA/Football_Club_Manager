package com.example.core.ResultState

sealed class MakeClubResult {
    data class Success(val uniqueNumber: String) : MakeClubResult()
    data class Error(val errorMessage: String) : MakeClubResult()
    data object Initial : MakeClubResult()
    data object Loading : MakeClubResult()
}
