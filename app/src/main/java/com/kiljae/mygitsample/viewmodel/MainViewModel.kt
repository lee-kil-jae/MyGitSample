package com.kiljae.mygitsample.viewmodel

import android.util.Log
import android.view.View
import com.kiljae.mygitsample.common.NotNullMutableLiveData
import com.kiljae.mygitsample.model.network.GithubApiInterface
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val github: GithubApiInterface): BaseViewModel() {

    companion object{
        val TAG = "MainViewModel"
    }

    val keyword = NotNullMutableLiveData<String>("")
    val count = NotNullMutableLiveData<Int>(0)

    fun onClickSearch(view: View){

        addDisposable(
            github.getUserSearch(keyword.value, 1)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.single())
                    .subscribe({
                        Log.d(TAG, "response: ${it}")
                        count.postValue(it.total_count)
                    },{
                         Log.d(TAG, "error: ${it.message}")
                        count.postValue(0)
                    })
        )

    }

}
