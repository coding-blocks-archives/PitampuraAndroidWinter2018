package com.codingblocks.notesdb

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NoteDatabase(context: Context?) :
    SQLiteOpenHelper(context, "notes.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL(
            """
            CREATE TABLE notes (
            id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
            title TEXT NOT NULL,
            desc TEXT NOT NULL);
        """.trimIndent()
        )

    }

    fun getAllNotes(): ArrayList<Note> {

        val notes = arrayListOf<Note>()

        val cursor = readableDatabase.query(
            "notes",
            null,
            null,
            null,
            null,
            null,
            null
        )

        while (cursor.moveToNext()) {

            val descColumnIndex = cursor.getColumnIndex("desc")
            val idColumnIndex = cursor.getColumnIndex("id")
            val titleColumnIndex = cursor.getColumnIndex("title")

            val title = cursor.getString(titleColumnIndex)
            val id = cursor.getInt(idColumnIndex)
            val desc = cursor.getString(descColumnIndex)

            notes.add(Note(title, desc, id))
        }

        cursor.close()

        return notes
    }

    fun insertNote(note: Note): Long {
        val contentValue = ContentValues()
        contentValue.put("title", note.title)
        contentValue.put("desc", note.description)

        return writableDatabase.insert("notes", null, contentValue)
    }

    fun getNoteWithId(id: Long): Note? {

        val cursor = readableDatabase.query(
            "notes",
            null,
            "id = ?",
            arrayOf(id.toString()),
            null,
            null,
            null,
            null
        )

        if (cursor.moveToNext()) {
            val descColumnIndex = cursor.getColumnIndex("desc")
            val idColumnIndex = cursor.getColumnIndex("id")
            val titleColumnIndex = cursor.getColumnIndex("title")

            val title = cursor.getString(titleColumnIndex)
            val noteId = cursor.getInt(idColumnIndex)
            val desc = cursor.getString(descColumnIndex)

            cursor.close()

            return Note(title, desc, noteId)
        }

        cursor.close()
        return null
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) = Unit


}