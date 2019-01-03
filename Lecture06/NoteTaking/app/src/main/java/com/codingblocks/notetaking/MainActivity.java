package com.codingblocks.notetaking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etSurname;
    ArrayList<Contact> contacts = new ArrayList<>();
    ContactAdapter contactAdapter;
    RecyclerView rvContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactAdapter = new ContactAdapter(contacts);

        rvContacts = findViewById(R.id.rvContacts);
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);

        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        rvContacts.setAdapter(contactAdapter);

        Button btnSend = findViewById(R.id.btnSubmit);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Get the inputs, create the Contact Object and populate the Rv
        Contact contact = new Contact(etName.getText().toString(),
                etSurname.getText().toString(),
                "Random");

        contacts.add(contact);

//        contactAdapter.notifyDataSetChanged();
        contactAdapter.notifyItemInserted(contacts.size() - 1);
//        rvContacts.setAdapter(contactAdapter);

        //Add this to the dataset
        //Reset the adapter

    }
}