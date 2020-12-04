package com.kiljae.mygitsample.model.network

import com.kiljae.mygitsample.common.data.DataUserSearchResult
import io.reactivex.Single

interface GithubApiInterface {
    fun getUserSearch(q: String, page: Int): Single<DataUserSearchResult>
}