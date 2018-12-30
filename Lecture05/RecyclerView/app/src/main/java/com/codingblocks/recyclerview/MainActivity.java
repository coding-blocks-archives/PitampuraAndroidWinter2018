package com.codingblocks.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts.add(new Contact("Pankaj", "Kumail", "1234567890"));
        contacts.add(new Contact("Sashrika", "Raghav", "1234567890"));
        contacts.add(new Contact("Jashpreet", "Abhishek", "1234567890"));
        contacts.add(new Contact("Bhumika", "Munir", "1234567890"));
        contacts.add(new Contact("Ravi", "Lavanya", "1234567890"));
        contacts.add(new Contact("Yash", "Harshit", "1234567890"));
        contacts.add(new Contact("Pankaj", "Kumail", "1234567890"));
        contacts.add(new Contact("Sashrika", "Raghav", "1234567890"));
        contacts.add(new Contact("Jashpreet", "Abhishek", "1234567890"));
        contacts.add(new Contact("Bhumika", "Munir", "1234567890"));
        contacts.add(new Contact("Ravi", "Lavanya", "1234567890"));
        contacts.add(new Contact("Yash", "Harshit", "1234567890"));

        ContactAdapter contactAdapter = new ContactAdapter(contacts, this);

        RecyclerView rv = findViewById(R.id.recyclerView);

//        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

//        rv.setLayoutManager(new LinearLayoutManager(this));

//        rv.setLayoutManager(new GridLayoutManager(this, 2));

        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        rv.setAdapter(contactAdapter);
    }
}
