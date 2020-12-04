package com.kiljae.mygitsample.common.data

data class DataUserSearchResult(var total_count: Int, var items: List<DataUser>) {
    constructor() : this(-1, listOf())
}