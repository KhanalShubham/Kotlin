package com.example.splashscreen

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.splashscreen.databinding.ActivitySplashRegisterBinding

class SplashRegisterActivity : AppCompatActivity() {
    lateinit var splashRegisterBinding: ActivitySplashRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(splashRegisterBinding.root)

        //setting up the spinner
        val gender= arrayListOf("Male", "Female", "Others")
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item,gender)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        splashRegisterBinding.spinner.adapter = adapter

        splashRegisterBinding.register.setOnClickListener(){
            val username = splashRegisterBinding.editTextText2.text.toString()
            val email = splashRegisterBinding.editTextText3.text.toString()
            val password = splashRegisterBinding.editTextTextPassword2.text.toString()
            val gender = splashRegisterBinding.spinner.selectedItem.toString()

            val sharedPreferences= getSharedPreferences("UserPrefences", MODE_PRIVATE)
            val editor= sharedPreferences.edit()
            editor.putString("username", username)
            editor.putString("email", email)
            editor.putString("password", password)
            editor.putString("gender", gender)

            startActivity(Intent(this@SplashRegisterActivity, SplashLoginActivity::class.java))
            finish()
        }


    }
}