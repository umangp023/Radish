package com.example.reddish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnSignUp.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)

            startActivity(intent)
        }

        btnLogin.setOnClickListener{
            val intent = Intent( this, MainActivity4::class.java)

            startActivity(intent)
        }
    }
}