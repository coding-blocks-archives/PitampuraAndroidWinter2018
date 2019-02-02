package com.codingblocks.roomdatabase

import android.arch.persistence.room.Room
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread
import kotlin.math.sign

class MainActivity : AppCompatActivity() {

    private val notes = arrayListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val noteAdapter = NotesAdapter(notes)

        rvNotes.layoutManager = LinearLayoutManager(this)

        rvNotes.adapter = noteAdapter

        thread {
            notes.addAll(MyApplication.myNoteDb.getNoteDao().getAllNotes())
            runOnUiThread {
                noteAdapter.notifyDataSetChanged()
            }
        }

        btnSubmit.setOnClickListener {

            val note = Note(
                etTitle.text.toString(),
                etDesc.text.toString(),
                url = Url("test.com", "test url")
            )

            thread {
                val id = MyApplication.myNoteDb.getNoteDao().insertNote(note)
                Log.e("TAG", "The note is inserted at id $id")
                val receivedNote = MyApplication.myNoteDb.getNoteDao().getNoteById(id)
                notes.add(receivedNote)
                runOnUiThread {
                    noteAdapter.notifyItemInserted(notes.size - 1)
                }
            }
            //Save this note to the db


//            notes[notes.size]  =re
//            noteAdapter.notifyDataSetChanged()
        }

        btnNewActivity.setOnClickListener {

//            val intent = Intent(this, NewActivity::class.java)
//
////            intent.putExtra()
//
//            startActivity(intent)

            applicationContext

            finish()

        }

    }
}
