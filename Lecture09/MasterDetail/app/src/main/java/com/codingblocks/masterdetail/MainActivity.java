package com.codingblocks.masterdetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    public void onRvItemClicked(Note note) {
        View view = findViewById(R.id.container2);

        if (view == null) {
            Intent intent = new Intent(this, DetailActivity.class);

            intent.putExtra("N", note);

//            intent.putExtra("T", note.getTitle());
//            intent.putExtra("S", note.getSubtitle());

            startActivity(intent);
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container2,
                            DetailFragment.newInstance(note))
                    .commit();
        }
    }
}