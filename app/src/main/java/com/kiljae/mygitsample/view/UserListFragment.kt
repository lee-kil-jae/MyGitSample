package com.kiljae.mygitsample.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.kiljae.mygitsample.R
import com.kiljae.mygitsample.common.data.MyHeader
import com.kiljae.mygitsample.databinding.FragmentUserListBinding
import com.kiljae.mygitsample.model.ListAdapterUser
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class UserListFragment: BaseFragment<FragmentUserListBinding>(){

    override val layoutResourceId: Int get() = R.layout.fragment_user_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.vmUserList = getViewModel()
        viewDataBinding.lifecycleOwner = this
    }

    fun search(keyword: String, header: MyHeader){
        rcvUserList.adapter = ListAdapterUser(viewDataBinding.vmUserList)
        viewDataBinding.vmUserList?.load(keyword, header)?.observe(this, Observer {
            (rcvUserList.adapter as ListAdapterUser).submitList(it)
        })
    }
}