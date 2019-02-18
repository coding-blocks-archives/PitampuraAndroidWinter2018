package com.codingblocks.workmanager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartWork.setOnClickListener {

            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .setRequiresBatteryNotLow(true)
                .setRequiresCharging(true)
                .build()


            val singleWorkRequest = OneTimeWorkRequestBuilder<MyWorker>()
                .setInitialDelay(12, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance().enqueue(singleWorkRequest)
        }

        btnStartPeriodicWork.setOnClickListener {

            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .setRequiresBatteryNotLow(true)
                .setRequiresCharging(true)
                .build()


            val periodicWork = PeriodicWorkRequestBuilder<MyWorker>(1, TimeUnit.DAYS)
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance().enqueue(periodicWork)
        }

    }
}
