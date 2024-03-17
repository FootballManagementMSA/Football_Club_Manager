package com.example.network_api.repository

import com.example.network_api.response.MainHomeStudentDataResponse
import com.example.network_api.response.RespResult

interface MainHomeRepository {
    suspend fun loadData(): RespResult<MainHomeStudentDataResponse>
}