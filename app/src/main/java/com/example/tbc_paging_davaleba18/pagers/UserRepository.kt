package com.example.tbc_paging_davaleba18.pagers

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.tbc_paging_davaleba18.models.User
import kotlinx.coroutines.flow.Flow

class UserRepository {

    fun getUsers(): Flow<PagingData<User>> {
        return Pager(
            config = PagingConfig(20, enablePlaceholders = false),
            pagingSourceFactory = { UserPagingSource() }
        ).flow
    }
}