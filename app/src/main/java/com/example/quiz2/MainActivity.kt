package com.example.quiz2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz2.R

class MainActivity : AppCompatActivity() {

    private lateinit var editTextA: EditText
    private lateinit var editTextB: EditText
    private lateinit var editTextC: EditText
    private lateinit var resultTextView: TextView
    private lateinit var buttonAdd: Button
    private lateinit var buttonSubAdd: Button
    private lateinit var buttonMulSub: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        editTextA = findViewById(R.id.edittext1)
        editTextB = findViewById(R.id.edittext2)
        editTextC = findViewById(R.id.edittext3)
        resultTextView = findViewById(R.id.empty_text_view)
        buttonAdd = findViewById(R.id.button1)
        buttonSubAdd = findViewById(R.id.button2)
        buttonMulSub = findViewById(R.id.button3)

        // Set onClick listeners for buttons
        buttonAdd.setOnClickListener { performCalculation("A+B+C") }
        buttonSubAdd.setOnClickListener { performCalculation("A-B+C") }
        buttonMulSub.setOnClickListener { performCalculation("A*B-C") }
    }

    private fun performCalculation(operation: String) {
        val a = editTextA.text.toString().toDoubleOrNull()
        val b = editTextB.text.toString().toDoubleOrNull()
        val c = editTextC.text.toString().toDoubleOrNull()

        if (a == null || b == null || c == null) {
            resultTextView.text = "Please enter valid numbers in all fields"
            return
        }

        val result = when (operation) {
            "A+B+C" -> a + b + c
            "A-B+C" -> a - b + c
            "A*B-C" -> a * b - c
            else -> 0.0
        }

        resultTextView.text = result.toString()
    }
}
