package com.kiljae.mygitsample

import android.os.Bundle
import com.kiljae.mygitsample.databinding.ActivityMainBinding
import com.kiljae.mygitsample.model.PagerAdapterUserList
import com.kiljae.mygitsample.view.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId: Int get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.vmMain = getViewModel()
        viewDataBinding.lifecycleOwner = this

        vpUserList.adapter = PagerAdapterUserList(supportFragmentManager)
    }
}