package com.example.splashscreen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.splashscreen.databinding.ActivitySplashScreenBinding

class SplashDashboardActivity : AppCompatActivity() {
    lateinit var splashScreenBinding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        splashScreenBinding=ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_splash_dashboard)


    }
}