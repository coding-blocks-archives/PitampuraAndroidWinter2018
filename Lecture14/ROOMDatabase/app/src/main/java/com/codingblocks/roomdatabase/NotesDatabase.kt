package com.codingblocks.roomdatabase

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Note::class, FavouriteNote::class, Url::class], version = 4)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    abstract fun getFavNoteDao(): FavNotesDao

    abstract fun getUrlDao(): UrlDao
}