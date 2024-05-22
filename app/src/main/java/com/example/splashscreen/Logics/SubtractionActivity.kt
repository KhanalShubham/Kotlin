package com.example.splashscreen.Logics

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.splashscreen.R
import com.example.splashscreen.databinding.ActivityMultiplyBinding
import com.example.splashscreen.databinding.ActivitySubtractionBinding

class SubtractionActivity: AppCompatActivity() {
    lateinit var subtractionBinding: ActivitySubtractionBinding

    private var number1: Int = 0
    private var number2: Int = 0
    private var sub: Int = 0
    private var life: Int = 3
    private var score: Int = 0
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        subtractionBinding=ActivitySubtractionBinding.inflate(layoutInflater)
        setContentView(subtractionBinding.root)

        starGame()

        subtractionBinding.ok.setOnClickListener {
            checkAnswer()
        }
        subtractionBinding.next.setOnClickListener {
            starGame()
        }
    }
    private fun starGame() {
        number1 = (0..100).random()
        number2 = (0..100).random()
        sub = number1 - number2
        subtractionBinding.textView11.text = number1.toString()
        subtractionBinding.textView12.text = number2.toString()
        subtractionBinding.editTextText5.text.clear()
        startTimer()
    }

    private fun startTimer(){
        timer?.cancel()
        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                subtractionBinding.textView13.text = "Time: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                subtractionBinding.timeScore.text = "0"
                life--
                subtractionBinding.life.text = life.toString()
                if (life > 0) {
                    starGame()
                } else {
                    Toast.makeText(this@SubtractionActivity, "Game Over", Toast.LENGTH_SHORT).show()
                }
            }
        }.start()
    }
    private fun checkAnswer() {
        val userInput = subtractionBinding.editTextText5.text.toString()
        if (userInput.isNotEmpty() && userInput.toInt() == sub) {
            score += 10
            subtractionBinding.score.text = score.toString()
            starGame()
        } else {
            life--
            subtractionBinding.life.text = life.toString()
            if (life > 0) {
                Toast.makeText(this, "Wrong answer, try again!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show()
                timer?.cancel()

            }
        }
    }

}