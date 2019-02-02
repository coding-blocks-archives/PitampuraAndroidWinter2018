package com.example.livedata

import android.app.Application
import android.arch.persistence.room.Room

class MyApplication : Application() {

    companion object {
        lateinit var noteDb: NoteDatabase
    }

    override fun onCreate() {
        super.onCreate()

        noteDb = Room.databaseBuilder(this, NoteDatabase::class.java, "note.db")
            .allowMainThreadQueries()
            .build()
    }

}