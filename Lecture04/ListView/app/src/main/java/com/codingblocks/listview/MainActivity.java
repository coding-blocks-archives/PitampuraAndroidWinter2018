package com.codingblocks.listview;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names.add("Pankaj");
        names.add("Sashrika");
        names.add("Jashpreet");
        names.add("Bhumika");
        names.add("Ravi");
        names.add("Yash");
        names.add("Giriraj");
        names.add("Lavanya");
        names.add("Kumail");
        names.add("Soham");
        names.add("Munir");
        names.add("Abhishek");
        names.add("Raghav");
        names.add("Ashu");
        names.add("Harshit");

        ListView lv = findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.item_row,
                R.id.tvRow,
                names);

        lv.setAdapter(arrayAdapter);

    }

}
