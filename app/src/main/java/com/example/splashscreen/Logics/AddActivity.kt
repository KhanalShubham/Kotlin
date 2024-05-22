package com.example.splashscreen.Logics

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.splashscreen.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var addBinding: ActivityAddBinding

    private var number1: Int = 0
    private var number2: Int = 0
    private var sum: Int = 0
    private var life: Int = 3
    private var score: Int = 0
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addBinding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(addBinding.root)

        initializeGame()

        addBinding.ok.setOnClickListener {
            checkAnswer()
        }

        addBinding.next.setOnClickListener {
            initializeGame()
        }
    }

    private fun initializeGame() {
        number1 = (0..100).random()
        number2 = (0..100).random()
        sum = number1 + number2
        addBinding.num1.text = number1.toString()
        addBinding.num2.text = number2.toString()
        addBinding.entryFieldSum.text.clear()
        startTimer()
    }

    private fun startTimer() {
        timer?.cancel()
        timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                addBinding.timeScore.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                addBinding.timeScore.text = "0"
                life--
                addBinding.life.text = life.toString()
                if (life > 0) {
                    initializeGame()
                } else {
                    Toast.makeText(this@AddActivity, "Game Over", Toast.LENGTH_SHORT).show()
                }
            }
        }.start()
    }

    private fun checkAnswer() {
        val userInput = addBinding.entryFieldSum.text.toString()
        if (userInput.isNotEmpty() && userInput.toInt() == sum) {
            score += 10
            addBinding.score.text = score.toString()
            initializeGame()
        } else {
            life--
            addBinding.life.text = life.toString()
            if (life > 0) {
                Toast.makeText(this, "Wrong answer, try again!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT).show()
                timer?.cancel()
            }
        }
    }
}
