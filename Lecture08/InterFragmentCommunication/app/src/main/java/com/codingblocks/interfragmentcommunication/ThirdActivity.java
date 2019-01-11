package com.codingblocks.interfragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity implements ClickHandler{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportFragmentManager().beginTransaction().replace(R.id.container3, new NoteFragment()).commit();
    }

    @Override
    public void onRvItemClicked(Note note) {
        Toast.makeText(this, note.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
