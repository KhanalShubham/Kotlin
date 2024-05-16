package com.example.splashscreen

import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.example.splashandbutton.HomeFragment
import com.example.splashscreen.databinding.ActivityNavigationBinding
import com.example.splashscreen.fragment.FavouriteFragment
import com.example.splashscreen.fragment.ProfileFragment
import com.example.splashscreen.fragment.SearchFragment
import com.google.android.material.navigation.NavigationView

class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var navigationBinding: ActivityNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigationBinding= ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(navigationBinding.root)
        setSupportActionBar(navigationBinding.toolbar)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        }

        var toggle= ActionBarDrawerToggle(
            this, navigationBinding.drawerLayout,
            navigationBinding.toolbar, R.string.Open_drawer, R.string.Close_drawer
        )
        navigationBinding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationBinding.navigationView.setNavigationItemSelectedListener(this)

        if(savedInstanceState==null){
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment()).commit()
        }

    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
       when(p0.itemId){
           R.id.home->{
               title="Home"
               supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment()).commit()
           }
           R.id.search-> supportFragmentManager.beginTransaction()
               .replace(R.id.frameLayout, SearchFragment()).commit()

           R.id.favourite -> supportFragmentManager.beginTransaction()
               .replace(R.id.frameLayout, FavouriteFragment()).commit()
           R.id.person-> supportFragmentManager.beginTransaction()
               .replace(R.id.frameLayout, ProfileFragment()).commit()
       }
        navigationBinding.drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }
    override fun onBackPressed(){
        if(navigationBinding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            navigationBinding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}