package com.codingblocks.pokemonapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.R.string
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://pokeapi.co/api/v2/pokemon/1")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) = Unit

            override fun onResponse(call: Call, response: Response) {

                val responseString: String? = response.body()?.string()

                responseString?.let { resp ->
                    Log.e("TAG", resp)
                    //Parsing the responseString using GSON
                    //Setting the arraylist to the adapter
                    //Notifying the adapter

                    val gson = Gson()
                    val pokemonResponse = gson.fromJson(resp, PokemonResponse::class.java)

                    Log.e("TAG", pokemonResponse.sprites.backDefault)

                    runOnUiThread {
                        tView.text = pokemonResponse.name.capitalize()
                    }

                } ?: kotlin.run {
                    Log.e("TAG", "Request failed")
                }
//                if (responseString != null) {
//                    //Parsing the responseString using GSON
//                    //Setting the arraylist to the adapter
//                    //Notifying the adapter
//                } else {
//                    //Show an error message
//                }
            }

        })

    }


}
