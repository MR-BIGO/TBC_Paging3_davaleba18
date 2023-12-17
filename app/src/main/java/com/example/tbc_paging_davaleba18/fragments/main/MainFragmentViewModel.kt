package com.example.tbc_paging_davaleba18.fragments.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.tbc_paging_davaleba18.models.User
import com.example.tbc_paging_davaleba18.pagers.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainFragmentViewModel : ViewModel() {

    private val _userList = MutableStateFlow<PagingData<User>>(PagingData.empty())
    val userList: Flow<PagingData<User>> get() = _userList

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            UserRepository().getUsers().collectLatest { pagingData ->
                _userList.value = pagingData
            }
        }
    }
}