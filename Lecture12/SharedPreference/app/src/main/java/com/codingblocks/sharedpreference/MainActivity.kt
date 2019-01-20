package com.codingblocks.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        count = PreferenceManager.getDefaultSharedPreferences(this).getInt("COUNT", 0)
        tvCount.text = count.toString()
//        count = getSharedPreferences("test", Context.MODE_PRIVATE).getInt("COUNT",0)

        btnIncrement.setOnClickListener {
            count++
            tvCount.text = count.toString()
        }
    }

    override fun onStop() {
        super.onStop()
        //Store the count to a persistent storage

//        val sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE)

        val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.putInt("COUNT", count)
//        val result = editor.commit()
        editor.apply()
    }

}
