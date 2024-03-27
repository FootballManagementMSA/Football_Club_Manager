package com.example.network_api.api

import com.example.network_api.entity.ClubSchedule
import com.example.network_api.response.MakeClubResponse
import com.example.network_api.response.MakeClubScheduleResponse
import com.example.network_api.response.SearchClubResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ClubApi {
    @Multipart
    @POST("/api/team-service/teams")
    suspend fun sendClubInfo(
        @Part("name") name: RequestBody,
        @Part("details") details: RequestBody,
        @Part emblem: MultipartBody.Part
    ): Response<MakeClubResponse>

    @GET("/api/team-service/team/search")
    suspend fun searchClub(
        @Query("search") code: String
    ): Response<SearchClubResponse>

    @POST("/api/team-service/{teamId}/schedules")
    suspend fun makeClubSchedule(
        @Path("teamId") teamId: Long,
        @Body clubSchedule: ClubSchedule
    ): Response<MakeClubScheduleResponse>
}