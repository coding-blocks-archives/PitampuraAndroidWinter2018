package com.codingblocks.saveinstancestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    companion object {
//        var count = 0
//
//        fun returnCount() = count
//    }

//    DONT USE THIS
//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        super.onCreate(savedInstanceState, persistentState)
//    }

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("TAG", "onCreate")
        btnAdd.setOnClickListener {
            count++
            tvCount.text = count.toString()
        }
    }

    override fun onStart() {
        Log.e("TAG", "onStart")
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        Log.e("TAG", "onResume")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

//        outState?.let {
//            it.putInt("COUNT",count)
//        }

        outState?.putInt("COUNT", count)
        Log.e("TAG", "onSaveInstanceState")
    }

    override fun onPause() {
        super.onPause()
        Log.e("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e("TAG", "onRestoreInstanceState")

        count = savedInstanceState?.getInt("COUNT") ?: 0
        tvCount.text = count.toString()
    }

}
