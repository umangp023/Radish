package com.example.reddish
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity



class MainActivity3 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btnBack = findViewById<Button>(R.id.btnBack)


        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        //val btnRegister = findViewById<Button>(R.id.btnRegister)
        //btnRegister.setOnClickListener{
            //val intent = Intent( this, MainActivity2::class.java)

            //startActivity(intent)
        //}





    }

    public fun register(view: View){
        //gets email from field
        val etEmailText = findViewById<View>(R.id.etEmail) as EditText
        val email = etEmailText.text.toString()
        //gets password from field
        val etPasswordText = findViewById<View>(R.id.etPass) as EditText
        val password = etPasswordText.text.toString()

        //prints username and password from field to console

        println(message = "-----from user input-----")
        println(message = email)
        println(message = password)
        println(message = "--------------------------")

        var ca = CreateAccount()
        ca.setCredentials(email, password)
        ca.start()

        //move to the search page? or send to login?
        setContentView(R.layout.activity_main2)
        val intent = Intent( this, MainActivity2::class.java)
        startActivity(intent)


    }







}