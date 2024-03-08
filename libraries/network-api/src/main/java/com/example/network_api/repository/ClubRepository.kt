package com.example.network_api.repository

import com.example.network_api.response.MakeClubResponse
import com.example.network_api.response.RespResult
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface ClubRepository {
    suspend fun sendClubInfo(name: RequestBody, emblem: MultipartBody.Part): RespResult<MakeClubResponse>
}