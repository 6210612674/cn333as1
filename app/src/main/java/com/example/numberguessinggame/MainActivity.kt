package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var editTextNumber: EditText
    private lateinit var imageButton: ImageButton
    private lateinit var imageButton2: ImageButton

    var random: Int = nextInt(1, 1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        editTextNumber = findViewById(R.id.editTextNumber)
        imageButton = findViewById(R.id.imageButton)
        imageButton2 = findViewById(R.id.imageButton2)

        textView2.text = "Enter your guess"


    }
}