package com.example.reddish

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

class GetSavedRecipe: Thread() {

    fun getSavedRecipe(){
        //api endpoint on aws
        val url = "http://18.222.27.18:5000/get_saved_recipes"
        //builds request to this endpoint with necessary form data
        val formBody = FormBody.Builder()
                .add("username", Singleton.username)
                .add("password", Singleton.password).build()
        //modified this to a post
        val request = Request.Builder().url(url).post(formBody).build()
        var client = OkHttpClient()
        var requester = client.newCall(request)
        var response = requester.execute()
        var body = response.body()

       ///return body!!.byteStream()


    }


    override fun run(){
        try{
            getSavedRecipe()
        }
        catch(e: Exception){
            println("yet again, failure")
        }
    }
}