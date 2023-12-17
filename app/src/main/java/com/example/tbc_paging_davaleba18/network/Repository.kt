package com.example.tbc_paging_davaleba18.network

import com.example.tbc_paging_davaleba18.models.PageResponse
import retrofit2.Response

class Repository {

    suspend fun getUsers(id: Int): Response<PageResponse>{
        return RetrofitInstance.api.getUsers(id)
    }
}