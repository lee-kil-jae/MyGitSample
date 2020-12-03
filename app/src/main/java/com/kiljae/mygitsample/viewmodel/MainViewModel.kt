package com.kiljae.mygitsample.viewmodel

import android.view.View
import com.kiljae.mygitsample.common.NotNullMutableLiveData

class MainViewModel: BaseViewModel() {

    val keyword = NotNullMutableLiveData<String>("")
    val count = NotNullMutableLiveData<Int>(0)

    fun onClickSearch(view: View){

    }
}