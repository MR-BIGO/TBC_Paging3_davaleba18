package com.example.tbc_paging_davaleba18.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tbc_paging_davaleba18.databinding.UserListItemBinding
import com.example.tbc_paging_davaleba18.models.User

class UsersRecyclerAdapter :
    PagingDataAdapter<User, UsersRecyclerAdapter.UsersRecyclerViewHolder>(UsersDiffCallBack()) {

    private class UsersDiffCallBack : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    inner class UsersRecyclerViewHolder(private val binding: UserListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            with(binding){
                tvId.text = user.id.toString()
                tvEmail.text = user.email
                tvFirstName.text = user.firstName
                tvLastName.text = user.lastName
                Glide.with(itemView.context).load(user.avatar).into(ivProfilePic)
            }
        }
    }

    override fun onBindViewHolder(holder: UsersRecyclerViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersRecyclerViewHolder {
        return UsersRecyclerViewHolder(
            UserListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}