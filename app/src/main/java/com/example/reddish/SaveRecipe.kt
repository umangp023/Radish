package com.example.reddish

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

class SaveRecipe: Thread() {

    private var recipe: String = ""

    fun setRecipe(rec: String){
        recipe = rec
    }

    fun saveRecipe() {
        //api endpoint on aws
        val url = "http://18.222.27.18:5000/save_recipe"
        //builds request to this endpoint with necessary form data
        val formBody = FormBody.Builder()
                .add("username", Singleton.username)
                .add("password", Singleton.password)
                .add("recipe", recipe).build()
        //modified this to a post
        val request = Request.Builder().url(url).post(formBody).build()
        var client = OkHttpClient()
        var requester = client.newCall(request)
        var response = requester.execute()
        var body = response.body()

        //return body!!.byteStream()

    }


    override fun run(){
        try{
            saveRecipe()

        }
        catch(e: Exception){
            println("yet again, failure")
        }
    }
}