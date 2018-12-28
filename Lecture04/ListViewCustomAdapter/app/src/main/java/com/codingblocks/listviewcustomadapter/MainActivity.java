package com.codingblocks.listviewcustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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

        ListView listView = findViewById(R.id.listView);

    }
}
