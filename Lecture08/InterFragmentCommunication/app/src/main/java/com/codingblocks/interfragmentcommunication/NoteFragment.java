package com.codingblocks.interfragmentcommunication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NoteFragment extends Fragment {

    ArrayList<Note> notes = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notes.add(new Note("Title1", "Subtitle1"));
        notes.add(new Note("Title2", "Subtitle2"));
        notes.add(new Note("Title3", "Subtitle3"));
        notes.add(new Note("Title4", "Subtitle4"));
        notes.add(new Note("Title5", "Subtitle5"));
        notes.add(new Note("Title6", "Subtitle6"));
        notes.add(new Note("Title7", "Subtitle7"));
        notes.add(new Note("Title8", "Subtitle8"));
        notes.add(new Note("Title9", "Subtitle9"));
        notes.add(new Note("Title10", "Subtitle10"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvNote = view.findViewById(R.id.rvNote);
        rvNote.setLayoutManager(new LinearLayoutManager(getContext()));

        FragmentActivity fragmentActivity = getActivity();

        ClickHandler clickHandler = (ClickHandler) fragmentActivity;

        NoteAdapter noteAdapter = new NoteAdapter(notes,clickHandler);

        rvNote.setAdapter(noteAdapter);
    }
}
