package com.kiljae.mygitsample.common

import com.kiljae.mygitsample.viewmodel.MainViewModel
import com.kiljae.mygitsample.viewmodel.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelpart = module{
    viewModel{
        MainViewModel()
    }

    viewModel{
        UserListViewModel()
    }
}

var myDiModule = listOf(
    viewModelpart
)