package com.example.madlab02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById(R.id.btnStart)

        // Navigate from the main activity to BillCalculatorActivity
        btnStart.setOnClickListener {
            val intent = Intent(this, BillCalculatorActivity::class.java)
            startActivity(intent)
        }
    }
}
