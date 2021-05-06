package com.example.reddish

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

class Login:Thread() {

    private var permPassword = ""
    private var permUsername = ""


    fun setCredentials(username: String, password: String){
        permUsername = username
        permPassword = password

    }

    fun getUsername(): String{
        return permUsername
    }

    private fun login(){

        //api endpoint on aws
        val url = "http://18.222.27.18:5000/login"
        //builds request to this endpoint with necessary form data
        val formBody = FormBody.Builder()
                .add("username", permUsername)
                .add("password", permPassword).build()




        //modified this to a post
        val request = Request.Builder().url(url).post(formBody).build()
        //var response = OkHttpClient().newCall(request).execute()
        //var body = response.body()

        var client = OkHttpClient()
        var requester = client.newCall(request)
        var response = requester.execute()
        var body = response.body()
        //if body contains success go to next page?

        println("------body------")
        println(body)
        println("-----------------")

        Singleton.username = permUsername
        Singleton.password = permPassword

        println("---------credentials---------")
        println(Singleton.username)
        println(Singleton.password)
        println("-------------------------------")


    }


    override fun run(){

        try{
            login()
        }
        catch(e: Exception){
            println("yet again, failure")
        }

    }

}