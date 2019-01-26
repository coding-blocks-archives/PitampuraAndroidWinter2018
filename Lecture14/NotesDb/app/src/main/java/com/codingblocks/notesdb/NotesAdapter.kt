package com.codingblocks.notesdb

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*

class NotesAdapter(private val notes: ArrayList<Note>) : RecyclerView.Adapter<NotesAdapter.NoteHolder>() {

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): NoteHolder {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.item_row, container, false)
        return NoteHolder(view)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote = notes[position]

        with(holder.itemView) {
            tvTitle.text = currentNote.title
            tvDesc.text = currentNote.description
        }
    }

    inner class NoteHolder(view: View) : RecyclerView.ViewHolder(view)
}