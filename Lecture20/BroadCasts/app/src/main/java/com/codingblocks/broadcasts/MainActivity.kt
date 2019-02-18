package com.codingblocks.broadcasts

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {

    private val myReceiver = MyReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent().apply {
            action = "mycustombroadcast"
            putExtra("USERNAME", "test")
            putExtra("PASSWORD", "password")
        }


        //Ensures that the intent never leaks out of your app
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)

//        sendBroadcast(intent)
    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter().apply {
            //            addAction(Intent.ACTION_POWER_CONNECTED)
//            addAction(Intent.ACTION_POWER_DISCONNECTED)
//            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction("mycustombroadcast")
        }

        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver, intentFilter)

//        registerReceiver(myReceiver, intentFilter)
    }


    override fun onStop() {
        super.onStop()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myReceiver)
//        unregisterReceiver(myReceiver)
    }

}
