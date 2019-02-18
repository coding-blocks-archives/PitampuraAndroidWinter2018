package com.codingblocks.services

import android.app.IntentService
import android.content.Intent

class MyIntentService : IntentService("MyIntentService") {

    override fun onCreate() {
        super.onCreate()
    }

    //Intent service uses fire and forget mechanism,
    //as in it'll stop itself once the code returns from the onHandleIntent method
    override fun onHandleIntent(intent: Intent?) {

        //Work done here runs in the background thread by default

    }

}