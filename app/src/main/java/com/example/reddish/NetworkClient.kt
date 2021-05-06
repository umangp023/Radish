package com.example.reddish


import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.InputStream

class NetworkClient: Thread() {

    //once they login successfully, their username and password are saved (since all methods require it)
    private var permUsername: String = ""
    private var permPassword: String = ""

    private var endpt = ""

    fun setEndPoint(endpt: Int){
        //0 -> test()
        //1 -> createAcct()
        //2 -> login()
    }

    fun test(){
        val url = "http://127.0.0.1:5000/"
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
        try{
            val response = requester.execute()

            val body = response.body()
            println("------body------")
            println(body)
            println("-----------------")
        }
        catch(e: Exception){
            //actual alert or something for user?
            println(message = "the request could not be made")
        }
    }

    fun createAcct(uname: String, pword: String) {

        println(message = "-----from network client-----")
        println(message = uname)
        println(message = pword)
        println(message = "-----------------------------")

        //api endpoint on aws
        val url = "http://127.0.0.1:5000/create_account"
        //builds request to this endpoint with necessary form data
        val formBody = FormBody.Builder()
            .addEncoded("username", uname)
            .addEncoded("password", pword).build()
        //modified this to a post
        val request = Request.Builder().url(url).post(formBody).build()
        println("-----url request---------")
        println(message = request)
        println("-------form body--------")
        println(message = formBody.toString())
        println("---------------------------")
        val client = OkHttpClient()
        val requester = client.newCall(request)
        //val response = requester.execute()
        try{
            val response = requester.execute()

            val body = response.body()
            println("------body------")
            println(body)
            println("-----------------")
            }
        catch(e: Exception){
            //actual alert or something for user?
            println(message = "the request could not be made")
        }




        //not sure if i want this return
        //return body!!.byteStream()

    }

    fun login(uname: String, pword: String){

        //api endpoint on aws
        val url = "http://127.0.0.1:5000/login"
        //builds request to this endpoint with necessary form data
        val formBody = FormBody.Builder()
            .add("username", uname)
            .add("password", pword).build()




        //modified this to a post
        val request = Request.Builder().url(url).post(formBody).build()
        val response = OkHttpClient().newCall(request).execute()
        val body = response.body()

        //modify this so it only works if username/password combo is right
        permPassword = pword
        permUsername = uname

        //not sure if i want this return
        //return body!!.byteStream()

    }


    fun searchRecipe(recipe: String): InputStream {
        //api endpoint on aws
        val url = "http://18.222.27.18:5000/search_recipes"
        //builds request to this endpoint with necessary form data
        val formBody = FormBody.Builder()
            .add("username", permUsername)
            .add("password", permPassword)
            .add("recipe", recipe).build()
        //modified this to a post
        val request = Request.Builder().url(url).post(formBody).build()
        val response = OkHttpClient().newCall(request).execute()
        val body = response.body()

        //not sure if i want this return
        return body!!.byteStream()

    }


    fun saveRecipe(recipe: String): InputStream {
        //api endpoint on aws
        val url = "http://18.222.27.18:5000/save_recipe"
        //builds request to this endpoint with necessary form data
        val formBody = FormBody.Builder()
            .add("username", permUsername)
            .add("password", permPassword)
            .add("recipe", recipe).build()
        //modified this to a post
        val request = Request.Builder().url(url).post(formBody).build()
        val response = OkHttpClient().newCall(request).execute()
        val body = response.body()

        return body!!.byteStream()

    }

    fun getSavedRecipe(): InputStream{
        //api endpoint on aws
        val url = "http://18.222.27.18:5000/get_saved_recipes"
        //builds request to this endpoint with necessary form data
        val formBody = FormBody.Builder()
            .add("username", permUsername)
            .add("password", permPassword).build()
        //modified this to a post
        val request = Request.Builder().url(url).post(formBody).build()
        val response = OkHttpClient().newCall(request).execute()
        val body = response.body()

        return body!!.byteStream()


    }

    fun deleteAcct(): InputStream {
        //api endpoint on aws
        val url = "http://18.222.27.18:5000/delete_account"
        //builds request to this endpoint with necessary form data
        val formBody = FormBody.Builder()
            .add("username", permUsername)
            .add("password", permPassword).build()
        //modified this to a delete
        val request = Request.Builder().url(url).delete(formBody).build()
        val response = OkHttpClient().newCall(request).execute()
        val body = response.body()

        return body!!.byteStream()

    }

    override fun run(){

    }




}