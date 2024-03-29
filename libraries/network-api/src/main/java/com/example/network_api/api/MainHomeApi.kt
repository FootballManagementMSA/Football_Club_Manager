package com.example.network_api.api

import com.example.network_api.response.MainHomeScheduleResponse
import com.example.network_api.response.MainHomeStudentDataResponse
import retrofit2.Response
import retrofit2.http.GET

interface MainHomeApi {

    @GET("/api/user-service/student")
    suspend fun loadStudentData(): Response<MainHomeStudentDataResponse>

    @GET("/api/user-service/schedule")
    suspend fun loadSchedule(): Response<MainHomeScheduleResponse>
}