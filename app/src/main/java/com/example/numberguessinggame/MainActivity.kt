package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var tvHint: TextView
    private lateinit var tvHead: TextView
    private lateinit var tvWrong: TextView
    private lateinit var etInput: EditText
    private lateinit var ibCheck: ImageButton
    private lateinit var ibReset: ImageButton
    private lateinit var ibGiveUp: ImageButton

    var random: Int = nextInt(1, 1000)
    var wrong: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        tvHint = findViewById(R.id.tvHint)
        tvHead = findViewById(R.id.tvHead)
        tvWrong= findViewById(R.id.tvWrong)
        etInput = findViewById(R.id.etInput)
        ibCheck = findViewById(R.id.ibCheck)
        ibReset = findViewById(R.id.ibReset)
        ibGiveUp = findViewById(R.id.ibGiveUp)

        tvHead.text = "Enter your guess"
        tvWrong.text = "wrong answer: $wrong"

        ibCheck.setOnClickListener {
            val num: Int = etInput.text.toString().toInt()
            checkAnswer(num)
        }

        ibReset.setOnClickListener {
            reset()
        }

        ibGiveUp.setOnClickListener {
            tvHead.text = "You lose!\nAnswer is $random"
            tvHint.text = "Reset to play again"
            etInput.text.clear()
        }
    }

    private fun checkAnswer(num: Int) {
        when {
            num < random -> {
                wrong++
                tvWrong.text = "wrong answer: $wrong"
                tvHead.text = "Try again!"
                tvHint.text = "Hint: It's higher!"
                Toast.makeText(this,"Wrong!", Toast.LENGTH_SHORT).show();
                etInput.text.clear()
            }
            num > random -> {
                wrong++
                tvWrong.text = "wrong answer: $wrong"
                tvHead.text = "Try again!"
                tvHint.text = "Hint: It's lower!"
                Toast.makeText(this,"Wrong!", Toast.LENGTH_SHORT).show();
                etInput.text.clear()
            }
            else -> {
                tvWrong.text = ""
                tvHead.text = "Congratulations!"
                tvHint.text = "wrong answer: $wrong"
                Toast.makeText(this,"Correct!", Toast.LENGTH_SHORT).show();
                etInput.text.clear()
            }
        }
    }

    private fun reset() {
        random = nextInt(1,1000)
        wrong = 0
        tvHead.text = "Enter your guess"
        tvHint.text = ""
        tvWrong.text = "wrong answer: $wrong"
        etInput.text.clear()
    }
}