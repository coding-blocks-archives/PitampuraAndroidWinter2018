package com.codingblocks.roomdatabase

import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread
import kotlin.math.sign

class MainActivity : AppCompatActivity() {

    private val noteDatabase by lazy {
        Room.databaseBuilder(this, NotesDatabase::class.java, "notes.db")
//            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    private val notes = arrayListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val noteAdapter = NotesAdapter(notes)

        rvNotes.layoutManager = LinearLayoutManager(this)

        rvNotes.adapter = noteAdapter

        thread {
            notes.addAll(noteDatabase.getNoteDao().getAllNotes())
            runOnUiThread {
                noteAdapter.notifyDataSetChanged()
            }
        }

        btnSubmit.setOnClickListener {

            val note = Note(etTitle.text.toString(), etDesc.text.toString())

            thread {
                val id = noteDatabase.getNoteDao().insertNote(note)
                Log.e("TAG", "The note is inserted at id $id")
                val receivedNote = noteDatabase.getNoteDao().getNoteById(id)
                notes.add(receivedNote)
                runOnUiThread {
                    noteAdapter.notifyItemInserted(notes.size - 1)
                }
            }
            //Save this note to the db


//            notes[notes.size]  =re
//            noteAdapter.notifyDataSetChanged()
        }

    }
}
