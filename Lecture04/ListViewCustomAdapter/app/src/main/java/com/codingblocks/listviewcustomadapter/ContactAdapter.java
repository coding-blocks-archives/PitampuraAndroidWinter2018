package com.codingblocks.listviewcustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    private ArrayList<Contact> contacts;
    private Context context;

    public ContactAdapter(ArrayList<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Contact getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(context);

        View inflatedView = li.inflate(R.layout.item_row,
                parent,
                false);

        bind(inflatedView, contacts.get(position));

        return inflatedView;
    }

    private void bind(View inflatedView, final Contact currentContact) {
        TextView tvName, tvSurname, tvPhone;
        tvName = inflatedView.findViewById(R.id.tvName);
        tvSurname = inflatedView.findViewById(R.id.tvSurname);
        tvPhone = inflatedView.findViewById(R.id.tvPhone);

        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        currentContact.getName(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        tvName.setText(currentContact.getName());
        tvSurname.setText(currentContact.getSurname());
        tvPhone.setText(currentContact.getNumber());
    }

}
