package com.kiljae.mygitsample.viewmodel

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.kiljae.mygitsample.common.data.DataUser
import com.kiljae.mygitsample.common.data.MyHeader
import com.kiljae.mygitsample.model.DataSourceUserManager
import com.kiljae.mygitsample.model.network.GithubApiInterface

class UserListViewModel(private val github: GithubApiInterface): BaseViewModel() {

    val config = PagedList.Config.Builder()
        .setInitialLoadSizeHint(5)
        .setPrefetchDistance(5)
        .setPageSize(20)
        .build()

    fun load(keyword: String, header: MyHeader) : LiveData<PagedList<DataUser>>{
        val dataSourceFactory = DataSourceUserManager.Factory(keyword, github, header)
        val pagedListBuilder = LivePagedListBuilder(dataSourceFactory, config)
        return pagedListBuilder.setInitialLoadKey(0).build()
    }
}