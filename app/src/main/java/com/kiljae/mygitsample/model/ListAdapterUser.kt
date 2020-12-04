package com.kiljae.mygitsample.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kiljae.mygitsample.R
import com.kiljae.mygitsample.common.data.DataUser
import com.kiljae.mygitsample.databinding.ItemUserBinding
import com.kiljae.mygitsample.viewmodel.UserListViewModel

class ListAdapterUser(var vm: UserListViewModel?) : PagedListAdapter<DataUser, RecyclerView.ViewHolder>(DIFF_CALLBACK){

    class UserViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root)

    companion object{
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<DataUser> =
            object : DiffUtil.ItemCallback<DataUser>(){
                override fun areItemsTheSame(oldItem: DataUser, newItem: DataUser): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: DataUser, newItem: DataUser): Boolean {
                    return oldItem.equals(newItem)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_user,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserViewHolder).binding.run {
            itemUser = getItem(position)
            vmUserList = vm
        }
    }

}