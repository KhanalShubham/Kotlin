package com.example.splashscreen.Logics

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.splashscreen.R
import com.example.splashscreen.databinding.ActivityGameOpeningBinding

class gameOpeningActivity : AppCompatActivity() {
    lateinit var gameOpeningBinding: ActivityGameOpeningBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        gameOpeningBinding=ActivityGameOpeningBinding.inflate(layoutInflater)
        setContentView(gameOpeningBinding.root)

        gameOpeningBinding.add.setOnClickListener{
            startActivity(Intent(this@gameOpeningActivity, AddActivity::class.java))}

        gameOpeningBinding.mul.setOnClickListener {
                startActivity(Intent(this@gameOpeningActivity, MultiplyActivity::class.java))}

        gameOpeningBinding.sub.setOnClickListener {
                    startActivity(Intent(this@gameOpeningActivity, SubtractionActivity::class.java))
        }
    }
}