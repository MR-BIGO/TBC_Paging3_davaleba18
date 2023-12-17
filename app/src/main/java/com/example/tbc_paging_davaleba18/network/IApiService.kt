package com.example.tbc_paging_davaleba18.network

import com.example.tbc_paging_davaleba18.models.PageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {

    @GET("users")
    suspend fun getUsers(@Query("page") page: Int): Response<PageResponse>
}