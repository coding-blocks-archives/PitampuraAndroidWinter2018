package com.codingblocks.alarms

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alarmManager: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val intent = Intent(this, MainActivity::class.java)

        val pi = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        btnSet.setOnClickListener {

            val triggerTime = etInterval.text.toString().toLong()

            val calendar = Calendar.getInstance().apply {
                timeInMillis = System.currentTimeMillis()
                set(Calendar.MONTH, 12)
                set(Calendar.DAY_OF_MONTH, 25)
                set(Calendar.YEAR, 2019)
                set(Calendar.HOUR_OF_DAY, 20)
                set(Calendar.MINUTE, 30)
            }


            //Triggers an alarm at 8:30 pm on December 25th, 2019
            alarmManager.set(
                AlarmManager.RTC,
                calendar.timeInMillis,
                pi
            )

            alarmManager.setRepeating(
                AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + triggerTime * 1000,
                60 * 1000,
                pi
            )
        }

    }
}
