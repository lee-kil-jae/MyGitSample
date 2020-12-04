package com.kiljae.mygitsample

import android.os.Bundle
import androidx.lifecycle.Observer
import com.kiljae.mygitsample.common.data.MyHeader
import com.kiljae.mygitsample.databinding.ActivityMainBinding
import com.kiljae.mygitsample.model.PagerAdapterUserList
import com.kiljae.mygitsample.view.BaseActivity
import com.kiljae.mygitsample.view.UserListFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId: Int get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding.vmMain = getViewModel()
        viewDataBinding.lifecycleOwner = this

        vpUserList.adapter = PagerAdapterUserList(supportFragmentManager)

        viewDataBinding.vmMain?.search?.observe(this@MainActivity, Observer {
            viewDataBinding.vmMain?.header?.let { header ->
                ((vpUserList.adapter as PagerAdapterUserList).getItem(0) as UserListFragment)
                    .search(it, header)
            }
        })
    }
}