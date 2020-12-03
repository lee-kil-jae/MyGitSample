package com.kiljae.mygitsample.model

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.kiljae.mygitsample.view.UserListFragment

class PagerAdapterUserList(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment {
        return UserListFragment()
    }

    override fun getCount(): Int {
        return 1
    }

}