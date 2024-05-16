package com.example.splashscreen.fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.splashscreen.adapter.TabAdapter
import com.example.splashscreen.databinding.ActivityTabBarBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabBarActivity : AppCompatActivity() {
    lateinit var tabBarBinding: ActivityTabBarBinding
    var tabList= arrayOf("Chats","Status","Calls")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        tabBarBinding=ActivityTabBarBinding.inflate(layoutInflater)
        setContentView(tabBarBinding.root)

        var FragmentManager: FragmentManager=supportFragmentManager
        var adapter= TabAdapter(FragmentManager,lifecycle)

        tabBarBinding.viewPager22.adapter=adapter

        TabLayoutMediator(tabBarBinding.tabLayout, tabBarBinding.viewPager22){
            tab, position -> tab.text=tabList[position]
        }.attach()
    }
}