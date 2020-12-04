package com.kiljae.mygitsample.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.kiljae.mygitsample.common.NotNullMutableLiveData
import com.kiljae.mygitsample.common.data.MyHeader
import com.kiljae.mygitsample.model.network.GithubApiInterface
import io.reactivex.schedulers.Schedulers

class MainViewModel(): BaseViewModel() {

    companion object{
        val TAG = "MainViewModel"
    }

    val keyword = NotNullMutableLiveData<String>("")
    val count = NotNullMutableLiveData<Int>(0)

    val search = MutableLiveData<String>()
    val header = MyHeader()

    fun onClickSearch(view: View){
        if(!keyword.value.isNullOrEmpty()) {
            search.postValue(keyword.value)
        }
    }

}
