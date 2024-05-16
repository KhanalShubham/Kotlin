package com.example.splashscreen.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.splashandbutton.HomeFragment
import com.example.splashscreen.fragment.ProfileFragment
import com.example.splashscreen.fragment.SearchFragment

class TabAdapter (var fragmentManager: FragmentManager,
                  var lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return HomeFragment()
            1 -> return ProfileFragment()
            2-> return SearchFragment()
            else->return HomeFragment()
        }
    }

}