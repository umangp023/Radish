package com.example.reddish


import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.nio.file.attribute.AclEntry.newBuilder

class TestAPI:Thread() {

    fun test(){
        val url = "http://18.222.27.18:5000/"
        //builds request to this endpoint with necessary form data

        //modified this to a post
        val request = Request.Builder().url(url).build()
        println("-----url request---------")
        println(message = request)
        println("-------form body--------")
        println(message = "no form body")
        println("---------------------------")
        val client = OkHttpClient()
        val requester = client.newCall(request)
        //val response = requester.execute()

        val response = requester.execute()

        val body = response.body()
        println("------body------")
        println(body)
        println("-----------------")


    }

    override fun run(){

            try{
                test()
            }
            catch(e: Exception){
                println("yet again, failure")
            }

        }






}