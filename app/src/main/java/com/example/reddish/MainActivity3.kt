package com.example.reddish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val etUserName = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPass = findViewById<EditText>(R.id.etPass)
        val etPassCom = findViewById<EditText>(R.id.etPassCom)

        var username: String
        var email: String
        var Pass: String
        var PassCom: String

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            startActivity(intent)
        }
    }
}