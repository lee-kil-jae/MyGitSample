package com.kiljae.mygitsample

import androidx.multidex.MultiDexApplication
import com.kiljae.mygitsample.common.myDiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(myDiModule)
        }
    }
}