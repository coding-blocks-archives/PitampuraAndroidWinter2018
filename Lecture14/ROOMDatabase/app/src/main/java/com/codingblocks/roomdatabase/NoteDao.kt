package com.codingblocks.roomdatabase

import android.arch.persistence.room.*

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note): Long

    @Insert
    fun insertNotes(notes: List<Note>)

    @Insert
    fun insertMultipleNotes(vararg notes: Note)

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Query("SELECT * FROM notesTable")
    fun getAllNotes(): List<Note>

    @Query("SELECT * FROM notesTable WHERE id = :noteId")
    fun getNoteById(noteId: Long): Note

}