package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var inputText = ""

    private fun appendToInput(text: String) {
        inputText += text
        updateDisplay()
    }

    private fun updateDisplay() {
        val display = findViewById<TextView>(R.id.display)
        display.text = inputText
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnOne = findViewById<Button>(R.id.btnOne)
        btnOne.setOnClickListener { appendToInput("1") }

    }
}