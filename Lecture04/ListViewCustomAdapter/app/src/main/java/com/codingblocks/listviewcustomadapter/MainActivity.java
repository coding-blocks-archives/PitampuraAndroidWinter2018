package com.codingblocks.listviewcustomadapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Something else");

//        getBaseContext();
//
//
//        LayoutInflater li = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//
//
        LayoutInflater layoutInflater = LayoutInflater.from(this);

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

        ListView listView = findViewById(R.id.listView);

        ContactAdapter contactAdapter = new ContactAdapter(contacts, this);

        listView.setAdapter(contactAdapter);
//
//        getBaseContext();

    }
}
