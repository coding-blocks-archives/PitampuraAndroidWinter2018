package com.codingblocks.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder>{

    private ArrayList<Contact> contacts;
    private Context context;

    public ContactAdapter(ArrayList<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemId) {
        LayoutInflater li = LayoutInflater.from(context);
        View inflatedView = li.inflate(R.layout.item_row,viewGroup,false);

        return new ContactHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder contactHolder, int position) {

        Contact currentContact = contacts.get(position);

        contactHolder.nameHolder.setText(currentContact.getName());
        contactHolder.surnameHolder.setText(currentContact.getSurname());
        contactHolder.numberHolder.setText(currentContact.getNumber());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactHolder extends RecyclerView.ViewHolder{

        TextView nameHolder, surnameHolder, numberHolder;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            nameHolder = itemView.findViewById(R.id.tvName);
            surnameHolder = itemView.findViewById(R.id.tvSurname);
            numberHolder = itemView.findViewById(R.id.tvPhone);
        }
    }

}
