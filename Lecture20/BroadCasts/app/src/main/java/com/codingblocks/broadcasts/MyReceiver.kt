package com.codingblocks.broadcasts

import android.app.AlarmManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {


        val userName = intent?.getStringExtra("USERNAME")
        val password = intent?.getStringExtra("PASSWORD")



//        val time: Long


//        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//
//        alarmManager.set(
//            AlarmManager.RTC,
//            time,
//            pi
//        )


//        Log.e("TAG", intent?.action)
//
//        val pendingResult = goAsync()
//
//        //System will kill this broadcast after 3-5 seconds
//
//
//        okhttpClient.newCall().enqueue {
//
//            onFailure(e : Exception, call : Call) {
//
//
//            }
//
//            onResponse(resp : ResponseBody) {
//
//                val result = resp.body().string()
//
//                //Convert using GSON
//                //Save to the DB
//
//                pendingResult.finish()
//            }
//
//        }

    }

}