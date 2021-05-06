package com.example.reddish

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

class SearchRecipe: Thread() {

    fun searchRecipe(recipe: String) {
        //api endpoint on aws
        val url = "http://18.222.27.18:5000/search_recipes"
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

        //not sure if i want this return


    }



    override fun run(){
        try{
            SearchRecipe()

        }
        catch(e: Exception){
            println("yet again, failure")
        }
    }

}