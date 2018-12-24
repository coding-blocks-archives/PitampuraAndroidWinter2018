package com.codingblocks.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {

    EditText etName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);


        Intent i = getIntent();
        String name = i.getStringExtra("NAME");
        Boolean value = i.getBooleanExtra("BOOL_VALUE", false);
        Integer intValue = i.getIntExtra("INTEGER_VALUE", 0);

        etName.setText(name + value + intValue);

    }
}
