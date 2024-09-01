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

    private fun clearInput(){
        inputText = ""
        updateDisplay()
    }

    private fun updateDisplay() {
        val display = findViewById<TextView>(R.id.display)
        display.text = inputText
    }

    private fun removeLastTerm() {
        val resultString = inputText.substring(0, inputText.length - 1)
        inputText = resultString
        updateDisplay()
    }

    private fun evaluateExpression() {
        when {
            inputText.contains(" x ") -> {
                val parts = inputText.split(" x ")
                if (parts.size == 2) {
                    try {
                        val num1 = parts[0].trim().toDouble()
                        val num2 = parts[1].trim().toDouble()
                        inputText = (num1 * num2).toString()
                    } catch (e: NumberFormatException) {
                        inputText = "Error"
                    }
                }
            }
            inputText.contains(" + ") -> {
                val parts = inputText.split(" + ")
                if (parts.size == 2) {
                    try {
                        val num1 = parts[0].trim().toDouble()
                        val num2 = parts[1].trim().toDouble()
                        inputText = (num1 + num2).toString()
                    } catch (e: NumberFormatException) {
                        inputText = "Error"
                    }
                }
            }
            inputText.contains(" - ") -> {
                val parts = inputText.split(" - ")
                if (parts.size == 2) {
                    try {
                        val num1 = parts[0].trim().toDouble()
                        val num2 = parts[1].trim().toDouble()
                        inputText = (num1 - num2).toString()
                    } catch (e: NumberFormatException) {
                        inputText = "Error"
                    }
                }
            }
            inputText.contains(" ÷ ") -> {
                val parts = inputText.split(" ÷ ")
                if (parts.size == 2) {
                    try {
                        val num1 = parts[0].trim().toDouble()
                        val num2 = parts[1].trim().toDouble()
                        inputText = if (num2 != 0.0) {
                            (num1 / num2).toString()
                        } else {
                            "Error"
                        }
                    } catch (e: NumberFormatException) {
                        inputText = "Error"
                    }
                }
            }
            inputText.contains(" % ") -> {
                val parts = inputText.split(" % ")
                if (parts.size == 2) {
                    try {
                        val num1 = parts[0].trim().toDouble()
                        val num2 = parts[1].trim().toDouble()
                        inputText = (num1 % num2).toString()
                    } catch (e: NumberFormatException) {
                        inputText = "Error"
                    }
                }
            }
        }
        updateDisplay()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener{clearInput()}

        val btnMultiplication = findViewById<Button>(R.id.btnMultiplication)
        btnMultiplication.setOnClickListener{appendToInput(" x ")}

        val btnPlus = findViewById<Button>(R.id.btnPlus)
        btnPlus.setOnClickListener{appendToInput(" + ")}

        val btnMinus = findViewById<Button>(R.id.btnMinus)
        btnMinus.setOnClickListener{appendToInput(" - ")}

        val btnPercentage = findViewById<Button>(R.id.btnPercentage)
        btnPercentage.setOnClickListener{appendToInput(" % ")}

        val btnDivision = findViewById<Button>(R.id.btnDivision)
        btnDivision.setOnClickListener{appendToInput(" ÷ ")}

        val btnEqual = findViewById<Button>(R.id.btnEqual)
        btnEqual.setOnClickListener{ evaluateExpression() }

        val btnErase = findViewById<Button>(R.id.btnErase)
        btnErase.setOnClickListener{ removeLastTerm() }

        val buttonIds = listOf(
            R.id.btnZero, R.id.btnOne, R.id.btnTwo, R.id.btnThree, R.id.btnFour,
            R.id.btnFive, R.id.btnSix, R.id.btnSeven, R.id.btnEight, R.id.btnNine
        )

        val buttons = buttonIds.map { id -> findViewById<Button>(id) }

        val buttonValues = listOf("0","1", "2", "3", "4", "5", "6", "7", "8","9")

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                appendToInput(buttonValues[index])
            }
        }

    }
}