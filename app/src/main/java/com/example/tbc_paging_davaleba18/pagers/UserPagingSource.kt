package com.example.tbc_paging_davaleba18.pagers

import android.util.Log.d
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.tbc_paging_davaleba18.models.User
import com.example.tbc_paging_davaleba18.network.Repository
import okio.IOException

class UserPagingSource : PagingSource<Int, User>() {

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val page = params.key ?: 1
        return try {
            val response = Repository().getUsers(page)
            val userList = response.body()!!.data
            d("mylist", "$userList")

            LoadResult.Page(
                data = userList,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (userList.isEmpty()) null else page + 1
            )
        } catch (e: IOException) {
            d("Response", "${e.message}")
            LoadResult.Error(e)

        } catch (e: Exception) {
            d("Response", "${e.message}")
            LoadResult.Error(e)
        }
    }
}