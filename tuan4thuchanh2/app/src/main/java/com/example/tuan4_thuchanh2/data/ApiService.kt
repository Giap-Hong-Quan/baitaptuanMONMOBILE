package com.example.tuan4_thuchanh2.data

import com.example.appname.data.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("researchUTH/tasks")
    suspend fun getTasks(): ApiResponse
}