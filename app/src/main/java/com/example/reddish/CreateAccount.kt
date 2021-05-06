package com.example.reddish

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.nio.file.attribute.AclEntry.newBuilder


class CreateAccount:Thread() {

    private var uname = ""
    private var pword = ""

    fun setCredentials(username: String, password: String){
        uname = username
        pword = password
    }


    private fun createAcct() {

        println(message = "-----create account thread-----")
        println(message = uname)
        println(message = pword)
        println(message = "-----------------------------")

        //api endpoint on aws
        val url = "http://18.222.27.18:5000/create_account"
        //builds request to this endpoint with necessary form data
        val formBody = FormBody.Builder()
                .add("username", uname)
                .add("password", pword).build()
        //modified this to a post
        val request = Request.Builder().url(url).post(formBody).build()
        println("-----url request---------")
        println(message = request)
        println("-------form body--------")
        println(message = formBody.toString())
        println("---------------------------")
        var client = OkHttpClient()
        var requester = client.newCall(request)
        //val response = requester.execute()
        ///try{
        var response = requester.execute()


        var body = response.body()
        println("------body------")
        println(body)
        println("-----------------")
        //}
        //catch(e: Exception){
            //actual alert or something for user?
         //   println(message = "the request could not be made")
        //}




        //not sure if i want this return
        //return body!!.byteStream()

    }


    override fun run(){
        try{
            createAcct()
        }
        catch(e: Exception){
            println("yet again, failure")
        }

    }



}