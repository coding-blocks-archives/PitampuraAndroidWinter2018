package com.codingblocks.interfragmentcommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ClickHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,
                        new NoteFragment())
                .commit();
    }

    @Override
    public void onRvItemClicked(Note currentNote) {
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("TITLE", currentNote.getTitle());
        intent.putExtra("SUBTITLE", currentNote.getSubtitle());

        startActivity(intent);
    }

}
