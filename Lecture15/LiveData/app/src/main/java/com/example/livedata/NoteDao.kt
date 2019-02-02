package com.example.livedata

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    fun getNoteById(id: Long): LiveData<Note>

    @Insert
    fun insertNote(note: Note): Long

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)
}