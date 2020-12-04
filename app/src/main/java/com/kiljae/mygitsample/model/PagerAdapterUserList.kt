package com.kiljae.mygitsample.model

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kiljae.mygitsample.view.UserListFragment

class PagerAdapterUserList(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager){
    val fragmentMap = mutableMapOf<Int, Fragment>()

    override fun getItem(position: Int): Fragment {
        if(fragmentMap[position] == null){
            fragmentMap[position] = UserListFragment()
        }
        return fragmentMap[position]!!
    }

    override fun getCount(): Int {
        return 1
    }

}