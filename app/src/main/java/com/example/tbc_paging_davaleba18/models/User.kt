package com.example.tbc_paging_davaleba18.models

import com.squareup.moshi.Json

data class User(
    val id: Int,
    val email: String,
    @Json(name = "first_name")
    val firstName: String,
    @Json(name = "last_name")
    val lastName: String,
    val avatar: String
)