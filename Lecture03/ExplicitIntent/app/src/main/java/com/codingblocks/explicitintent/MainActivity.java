package com.codingblocks.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);

        final Intent intent = new Intent(getBaseContext(), NewActivity.class);
//        Intent intent = new Intent(this,NewActivity.class);
//        Intent intent = new Intent(MainActivity.this,NewActivity.class);

        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start an intent for the New Activity

                startActivity(intent);
            }
        });
    }
}
