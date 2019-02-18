package com.codingblocks.services

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.support.v4.app.NotificationCompat
import android.util.Log
import kotlin.concurrent.thread

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()

        val intent = Intent(this, MyService::class.java)

        intent.putExtra("KEY", true)

        val pi = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val notification: Notification = NotificationCompat.Builder(this, "DEFAULT_CHANNEL")
            .setContentTitle("Running the service")
            .setSmallIcon(R.drawable.ic_icon)
            .addAction(R.drawable.ic_icon, "Stop", pi)
            .build()

        startForeground(12345, notification)

        registerReceiver(PowerReceiver(), IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

//        val notNullIntent = intent!!

        //If the service was started by clicked the "Stop" button on the notification, stop the service


        intent?.let {
            if (it.hasExtra("KEY")) {
                stopSelf()
            }
        }

        Log.e("TAG", "flag is $flags")

        thread {

            Thread.sleep(5000)

            //DO some work here

//            stopSelf()

        }

        return START_REDELIVER_INTENT
    }

    override fun onBind(intent: Intent?) = null

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "Service destroyed")
    }

}