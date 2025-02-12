package com.example.unittesting

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)


        // Get Data from Intent
        val text1 = intent.getStringExtra("TEXT_1") ?: "No Text Provided"
        val text2 = intent.getStringExtra("TEXT_2") ?: "No Text Provided"

        // Display Received Data
        val textView = findViewById<TextView>(R.id.textViewReceived)
        textView.text = "$text1 $text2"

    }
}