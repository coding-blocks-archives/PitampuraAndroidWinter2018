package com.example.livedata

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val notes = arrayListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Observes this particular node forever
//        MyApplication.noteDb.getNoteDao().getNoteById(0).observeForever { note ->
//
//            note?.let {
//                Log.e("TAG", "${it.description} ${it.title}")
//            }
//
//        }

        MyApplication.noteDb.getNoteDao().getNotes().observe(this, Observer<List<Note>> {
            Log.e("TAG", "The number of items in the database is ${it?.size}")
        })

        btnInsert.setOnClickListener {

            val note = Note(
                title = "Title ${System.currentTimeMillis()}",
                description = "Desc ${System.currentTimeMillis()}"
            )

            MyApplication.noteDb.getNoteDao().insertNote(note)

        }

    }
}
