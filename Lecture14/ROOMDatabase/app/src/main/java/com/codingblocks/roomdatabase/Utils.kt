package com.codingblocks.roomdatabase

import android.arch.persistence.room.Room
import android.content.Context

class Utils {

    companion object {

        fun getRoomDb(context: Context): NotesDatabase {

            return Room.databaseBuilder(context, NotesDatabase::class.java, "notes.db").build()

        }
    }

}