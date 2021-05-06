package com.example.reddish

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request

class DeleteAccount: Thread() {

    fun deleteAcct() {
        //api endpoint on aws
        val url = "http://18.222.27.18:5000/delete_account"
        //builds request to this endpoint with necessary form data
        val formBody = FormBody.Builder()
                .add("username", Singleton.username)
                .add("password", Singleton.password).build()
        //modified this to a delete
        val request = Request.Builder().url(url).delete(formBody).build()
        var client = OkHttpClient()
        var requester = client.newCall(request)
        var response = requester.execute()
        var body = response.body()

        //return body!!.byteStream()

    }


    override fun run(){
        try{
            DeleteAccount()

        }
        catch(e: Exception){
            println("yet again, failure")
        }
    }
}