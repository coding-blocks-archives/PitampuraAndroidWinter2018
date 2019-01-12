package com.codingblocks.masterdetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private ArrayList<Note> notes;
    private Context ctx;
    private ClickHandler clickHandler;

    public NoteAdapter(ArrayList<Note> notes, ClickHandler clickHandler) {
        this.notes = notes;
        this.clickHandler = clickHandler;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ctx = viewGroup.getContext();

        LayoutInflater li = LayoutInflater.from(ctx);
        View view = li.inflate(R.layout.item_note, viewGroup, false);

        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, final int i) {
        final Note currentNote = notes.get(i);
        noteHolder.tvTitle.setText(currentNote.getTitle());
        noteHolder.tvSubTitle.setText(currentNote.getSubtitle());

        noteHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickHandler.onRvItemClicked(currentNote);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvSubTitle;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            tvSubTitle = itemView.findViewById(R.id.tvSubTitle);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }

}
