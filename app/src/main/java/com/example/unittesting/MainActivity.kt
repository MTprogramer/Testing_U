package com.example.unittesting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize Views
        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val buttonSend = findViewById<Button>(R.id.buttonSend)

        // Handle Button Click
        buttonSend.setOnClickListener {
            val text1 = editText1.text.toString()
            val text2 = editText2.text.toString()

            // Start Second Activity and Send Data
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("TEXT_1", text1)
            intent.putExtra("TEXT_2", text2)
            startActivity(intent)
        }

    }
}