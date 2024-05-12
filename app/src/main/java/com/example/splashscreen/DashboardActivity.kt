package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.splashscreen.databinding.ActivityDashboardBinding
import com.example.splashscreen.fragment.FavouriteFragment
import com.example.splashscreen.fragment.HomeFragment
import com.example.splashscreen.fragment.ProfileFragment
import com.example.splashscreen.fragment.SearchFragment

class DashboardActivity : AppCompatActivity() {
    lateinit var dashboardBinding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dashboardBinding= ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(dashboardBinding.root)
        replaceFragment(HomeFragment())
        dashboardBinding.buttonNavigationBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.search -> replaceFragment(SearchFragment())
                R.id.favourite -> replaceFragment(FavouriteFragment())
                R.id.person -> replaceFragment(ProfileFragment())
                else ->{}
            }
            true

        }


    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager=supportFragmentManager
        val fragmentTransaction: FragmentTransaction= fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}