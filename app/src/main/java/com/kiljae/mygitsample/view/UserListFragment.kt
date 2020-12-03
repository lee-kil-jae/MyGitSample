package com.kiljae.mygitsample.view

import android.os.Bundle
import android.view.View
import com.kiljae.mygitsample.R
import com.kiljae.mygitsample.databinding.FragmentUserListBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel

class UserListFragment: BaseFragment<FragmentUserListBinding>(){

    override val layoutResourceId: Int get() = R.layout.fragment_user_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.vmUserList = getViewModel()
    }
}