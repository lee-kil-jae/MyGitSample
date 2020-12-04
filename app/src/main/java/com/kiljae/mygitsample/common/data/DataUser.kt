package com.kiljae.mygitsample.common.data

data class DataUser(var id: Int, var login: String, var avatar_url: String) {
    constructor(): this(-1, "", "")
}