package com.example.tbc_paging_davaleba18.models

import com.squareup.moshi.Json

data class PageResponse(
    val page: Int,
    @Json(name = "per_page")
    val perPage: Int,
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int,
    val data: List<User>,
    val support: Support
)
