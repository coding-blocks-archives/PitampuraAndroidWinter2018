package com.codingblocks.workmanager

import android.content.Context
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {

        //This runs on a separate thread

        //Once the work is done, either return :

//        return Result.failure() //Won't retry this task

//        return Result.retry() // This will retry the task

        return Result.success()
    }

    
}