package com.codingblocks.roomdatabase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlin.concurrent.thread

class NewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        thread {
            MyApplication.myNoteDb.getNoteDao().getAllNotes()
        }
    }
}
