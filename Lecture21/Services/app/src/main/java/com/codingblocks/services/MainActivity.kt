package com.codingblocks.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.job.JobScheduler
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val connectivityService = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

//        connectivityService.addDefaultNetworkActiveListener {
//            //network is now connected
//        }

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(
                NotificationChannel(
                    "DEFAULT_CHANNEL",
                    "This is the default channel",
                    NotificationManager.IMPORTANCE_MIN
                )
            )
        }

        val intent = Intent(this, MyService::class.java)

        btnStart.setOnClickListener {
            ContextCompat.startForegroundService(this, intent)
        }

//        stopService(intent)

    }

}
