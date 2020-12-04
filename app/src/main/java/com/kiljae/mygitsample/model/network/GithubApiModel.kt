package com.kiljae.mygitsample.model.network

import com.kiljae.mygitsample.common.data.DataUserSearchResult
import io.reactivex.Single

class GithubApiModel(private val github: GithubApiService) : GithubApiInterface {
    companion object{
        val DEFAULT_PER_PAGE = 20
    }

    override fun getUserSearch(q: String, page: Int): Single<DataUserSearchResult> {
        return github.getUserSearch(q = q, page = page, per_page = DEFAULT_PER_PAGE)
    }
}