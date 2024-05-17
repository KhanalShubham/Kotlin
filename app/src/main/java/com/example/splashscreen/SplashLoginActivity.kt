package com.example.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.splashscreen.databinding.ActivitySplashLoginBinding

class SplashLoginActivity : AppCompatActivity() {
    private lateinit var splashLoginBinding: ActivitySplashLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        splashLoginBinding = ActivitySplashLoginBinding.inflate(layoutInflater)
        setContentView(splashLoginBinding.root)

        splashLoginBinding.signup.setOnClickListener {
            startActivity(Intent(this@SplashLoginActivity, SplashRegisterActivity::class.java))
        }
        splashLoginBinding.loginButton.setOnClickListener{
            val username= splashLoginBinding.editTextText.text.toString()
            val password= splashLoginBinding.editTextTextPassword.text.toString()

            val sharedPreferences=getSharedPreferences("UserPrefence", MODE_PRIVATE)
            val savedUsername=sharedPreferences.getString("username", null)
            val savedPassword= sharedPreferences.getString("password", null)

            if(username== savedUsername && password==savedPassword){
                startActivity(Intent(this@SplashLoginActivity, SplashDashboardActivity::class.java))
                finish()
            }else {
                //show error message
            }
        }
    }
}
