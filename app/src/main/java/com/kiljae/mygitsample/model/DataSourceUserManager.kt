package com.kiljae.mygitsample.model

import android.util.Log
import androidx.paging.DataSource
import androidx.paging.ItemKeyedDataSource
import com.kiljae.mygitsample.common.data.DataUser
import com.kiljae.mygitsample.common.data.MyHeader
import com.kiljae.mygitsample.model.network.GithubApiInterface
import com.kiljae.mygitsample.viewmodel.MainViewModel
import io.reactivex.schedulers.Schedulers

class DataSourceUserManager private constructor(val keyword: String, val github: GithubApiInterface, val header: MyHeader): ItemKeyedDataSource<Int, DataUser>() {

    class Factory(val keyword: String, val github: GithubApiInterface, val header: MyHeader): DataSource.Factory<Int, DataUser>(){
        override fun create(): DataSource<Int, DataUser> {
            return DataSourceUserManager(keyword, github, header)
        }
    }

    var pageIndex: Int = 1

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<DataUser>
    ) {
        pageIndex = 1
        github.getUserSearch(keyword, pageIndex)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
            .subscribe({
                header.totalUserCount = it.total_count
                callback.onResult(it.items)
            },{
                Log.d(MainViewModel.TAG, "error: ${it.message}")
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<DataUser>) {
        pageIndex += 1
        github.getUserSearch(keyword, pageIndex)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
            .subscribe({
                callback.onResult(it.items)
            },{
                Log.d(MainViewModel.TAG, "error: ${it.message}")
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<DataUser>) {

    }

    override fun getKey(item: DataUser): Int {
        return item.id
    }
}