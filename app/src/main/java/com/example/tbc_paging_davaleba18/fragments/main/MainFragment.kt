package com.example.tbc_paging_davaleba18.fragments.main

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tbc_paging_davaleba18.BaseFragment
import com.example.tbc_paging_davaleba18.adapters.UsersRecyclerAdapter
import com.example.tbc_paging_davaleba18.databinding.FragmentMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel: MainFragmentViewModel by viewModels()
    private var recyclerAdapter = UsersRecyclerAdapter()

    override fun setUp() {
        setUpRv()
        bindObservers()
    }

    private fun setUpRv() {
        binding.rvUsers.layoutManager = LinearLayoutManager(context)
        binding.rvUsers.adapter = recyclerAdapter
    }

    private fun bindObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.userList.collectLatest { pagingData ->
                    recyclerAdapter.submitData(pagingData)
                }
            }
        }
    }


}