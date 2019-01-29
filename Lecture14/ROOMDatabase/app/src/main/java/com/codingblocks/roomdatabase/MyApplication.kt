package com.codingblocks.roomdatabase

import android.app.Application
import android.arch.persistence.room.Room
import android.util.Log

class MyApplication : Application() {

    companion object {
        lateinit var myNoteDb: NotesDatabase
    }

    override fun onCreate() {
        super.onCreate()
        myNoteDb = Room.databaseBuilder(this, NotesDatabase::class.java, "notes.db").build()
        Log.e("TAG", "Application was started")
    }
}