package com.codingblocks.notesdb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val noteDb by lazy {
        NoteDatabase(this)
    }

    private val notes by lazy {
        noteDb.getAllNotes()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val noteAdapter = NotesAdapter(notes)

        rvNotes.layoutManager = LinearLayoutManager(this)

        rvNotes.adapter = noteAdapter

        btnSubmit.setOnClickListener {

            val note = Note(etTitle.text.toString(), etDesc.text.toString())

            //Save this note to the db
            val id = noteDb.insertNote(note)

            if (id != -1L) {

                val insertedNote: Note? = noteDb.getNoteWithId(id)

                insertedNote?.let { fetchedNote ->
                    notes.add(fetchedNote)
                    noteAdapter.notifyItemInserted(notes.size - 1)
                }

            } else
                Toast.makeText(this, "There was an error saving this to the db", Toast.LENGTH_SHORT).show()

        }

    }
}
