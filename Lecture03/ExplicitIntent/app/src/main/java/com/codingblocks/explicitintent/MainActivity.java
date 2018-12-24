package com.codingblocks.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);

        Button btnHello = findViewById(R.id.btnHello);

        final Intent intent = new Intent(getBaseContext(), NewActivity.class);
//        Intent intent = new Intent(this,NewActivity.class);
//        Intent intent = new Intent(MainActivity.this,NewActivity.class);

        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start an intent for the New Activity
                String name = etName.getText().toString();

                intent.putExtra("NAME",name);
                intent.putExtra("INTEGER_VALUE",5);
                intent.putExtra("BOOL_VALUE", false);

                startActivity(intent);
            }
        });
    }
}
