package com.kiljae.mygitsample.common

import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL

object BindingAdapterImageView {

    @BindingAdapter("drawBackgroundUrl")
    @JvmStatic
    fun drawBackgroundUrl(view: ImageView, strUrl: String){
        if(!strUrl.isNullOrEmpty()){
            GlobalScope.launch(Dispatchers.Main) {
                val bitmap = async(Dispatchers.Default){
                    var conn = URL(strUrl).openConnection()
                    conn.connect()
                    BitmapFactory.decodeStream(conn.getInputStream())
                }
                view.setImageBitmap(bitmap.await())
            }
        }
    }

}