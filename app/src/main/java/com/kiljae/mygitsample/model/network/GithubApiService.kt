package com.kiljae.mygitsample.model.network

import com.kiljae.mygitsample.common.data.DataUserSearchResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface GithubApiService {
    @Headers("Content-Type: application/json",
            "Connection: keep-alive")
    @GET("/search/users")
    fun getUserSearch(@Query("q") q: String, @Query("page") page: Int, @Query("per_page") per_page: Int): Single<DataUserSearchResult>
}