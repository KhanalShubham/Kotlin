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

class MultiplyActivity : AppCompatActivity() {
    lateinit var multiplyBinding: ActivityMultiplyBinding

    private var number1: Int = 0
    private var number2: Int = 0
    private var mul: Int = 0
    private var life: Int = 3
    private var score: Int = 0
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        multiplyBinding=ActivityMultiplyBinding.inflate(layoutInflater)
        setContentView(multiplyBinding.root)

        starGame()

        multiplyBinding.ok.setOnClickListener {
            checkAnswer()
        }
        multiplyBinding.next.setOnClickListener {
            starGame()
        }
    }
    private fun starGame() {
        number1 = (0..100).random()
        number2 = (0..100).random()
        mul = number1 * number2
        multiplyBinding.textView11.text = number1.toString()
        multiplyBinding.textView12.text = number2.toString()
        multiplyBinding.editTextText5.text.clear()
        startTimer()
    }

    private fun startTimer(){
        timer?.cancel()
        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                multiplyBinding.textView13.text = "Time: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                multiplyBinding.timeScore.text = "0"
                life--
                multiplyBinding.life.text = life.toString()
                if (life > 0) {
                    starGame()
                } else {
                    Toast.makeText(this@MultiplyActivity, "Game Over", Toast.LENGTH_SHORT).show()
                }
            }
        }.start()
    }
    private fun checkAnswer() {
        val userInput = multiplyBinding.editTextText5.text.toString()
        if (userInput.isNotEmpty() && userInput.toInt() == mul) {
            score += 10
            multiplyBinding.score.text = score.toString()
            starGame()
        } else {
            life--
            multiplyBinding.life.text = life.toString()
            if (life > 0) {
                Toast.makeText(this, "Wrong answer, try again!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show()
                timer?.cancel()

            }
        }
    }

}