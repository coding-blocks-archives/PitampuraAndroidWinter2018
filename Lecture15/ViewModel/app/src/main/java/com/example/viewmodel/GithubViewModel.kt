package com.example.viewmodel

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.util.ArrayList

class GithubViewModel : ViewModel() {

    private var githubUsers = arrayListOf<GithubUser>()

    fun getUsers(url: String): ArrayList<GithubUser> {

        if (githubUsers.isEmpty()) {
            makeNetworkCall(url)
        }

        return githubUsers
    }

    fun getNewUser(url: String): ArrayList<GithubUser> {

        makeNetworkCall(url)
        return githubUsers
    }

    private fun makeNetworkCall(url: String) {
        //Make the network call and add data to the adapter
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                //Add a breaking condition for this retry mechanism
                //                call.enqueue(this);
                e.printStackTrace()
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                if (response.code() == 200) {
                    val jsonResponse = response.body()!!.string()

                    val gson = Gson()

                    val githubResponse = gson.fromJson(jsonResponse, GithubResponse::class.java)

                    githubUsers.addAll(githubResponse.items)

                    Log.e("TAG", jsonResponse)
                }
            }
        })
    }

}