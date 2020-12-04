package com.kiljae.mygitsample.common.data

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.kiljae.mygitsample.BR

class MyHeader: BaseObservable() {
    @get:Bindable
    var totalUserCount: Int = 0
        set(value){
            field = value
            notifyPropertyChanged(BR.totalUserCount)
        }
}