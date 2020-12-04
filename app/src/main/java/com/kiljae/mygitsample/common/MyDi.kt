package com.kiljae.mygitsample.common

import com.kiljae.mygitsample.model.network.GithubApiInterface
import com.kiljae.mygitsample.model.network.GithubApiModel
import com.kiljae.mygitsample.model.network.GithubApiService
import com.kiljae.mygitsample.viewmodel.MainViewModel
import com.kiljae.mygitsample.viewmodel.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.fastjson.FastJsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL = "https://api.github.com"

var apiModelPart = module {
    factory<GithubApiInterface> {
        GithubApiModel(get())
    }
}

var apiDevPart = module {
    single<GithubApiService>{
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .build()
                .create(GithubApiService::class.java)
    }
}

var viewModelpart = module{
    viewModel{
        MainViewModel(get())
    }

    viewModel{
        UserListViewModel()
    }
}

var myDiModule = listOf(
        apiDevPart,
        apiModelPart,
        viewModelpart
)