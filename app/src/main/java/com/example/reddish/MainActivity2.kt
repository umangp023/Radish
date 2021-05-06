package com.example.reddish

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnSignUp = findViewById<Button>(R.id.btnSignUp)


        btnSignUp.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)

            startActivity(intent)
        }

        //val btnLogin = findViewById<Button>(R.id.btnLogin)
        //btnLogin.setOnClickListener{
            //val intent = Intent( this, MainActivity4::class.java)

            //startActivity(intent)
        //}


    }



    public fun login(view: View) {
        //gets email from field
        val etEmailText = findViewById<View>(R.id.etUsername) as EditText
        val email = etEmailText.text.toString()
        //gets password from field
            //password text field was named email
        val etPasswordText = findViewById<View>(R.id.etEmail) as EditText
        val password = etPasswordText.text.toString()

        println("-----calling login-----")

        //set credentials from the users as the ones used in the login
        var log = Login()
        log.setCredentials(email, password)
        log.start()

        println("----after calling login-----")

        //move to the search page?
        setContentView(R.layout.activity_main5)
        val intent = Intent( this, MainActivity5::class.java)

        startActivity(intent)
        //btnLogin.setOnClickListener{
        //val intent = Intent( this, MainActivity4::class.java)

        //startActivity(intent)
        //}

    }
}