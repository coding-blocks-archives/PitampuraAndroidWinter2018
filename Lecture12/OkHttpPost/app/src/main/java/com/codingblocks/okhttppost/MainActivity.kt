package com.codingblocks.okhttppost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = User(
            "Harshit",
            "Dwivedi",
            "Delhi",
            24
        )

        val client = OkHttpClient()

        val jsonMediaType: MediaType = MediaType.get("application/json")

        val body: RequestBody = RequestBody.create(jsonMediaType, Gson().toJson(user))

        val request = Request.Builder()
            .url("https://ptsv2.com/t/f2dag-1547970116/post")
            .header("customHeader", "sent from android device")
            .post(body)
            .build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) = Unit

            override fun onResponse(call: Call, response: Response) {
                Log.e("TAG", response.body()?.string())
            }

        })

    }
}
