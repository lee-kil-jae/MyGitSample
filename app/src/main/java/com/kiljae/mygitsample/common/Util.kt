package com.kiljae.mygitsample.common

import java.text.DecimalFormat

object Util {

    @JvmStatic
    fun prettyText(value : Int): String{
        val df = DecimalFormat("#,###")
        return (df.format(value.toLong()) as String)
    }
}