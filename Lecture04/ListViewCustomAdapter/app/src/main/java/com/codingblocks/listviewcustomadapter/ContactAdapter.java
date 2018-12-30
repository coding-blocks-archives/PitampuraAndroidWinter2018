package com.codingblocks.listviewcustomadapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
        Log.e("TAG", "getView: " + convertView);
        LayoutInflater li = LayoutInflater.from(context);

        if (convertView == null) {
            convertView = li.inflate(
                    R.layout.item_row,
                    parent,
                    false);

            ViewHolder vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }

        ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        bind(viewHolder, position);
        return convertView;
    }

    private void bind(ViewHolder vh, int position) {

        final Contact currentContact = contacts.get(position);

//        ViewHolder vh = (ViewHolder) inflatedView.getTag();

        vh.nameHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,
                        currentContact.getName(),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
        vh.nameHolder.setText(currentContact.getName());
        vh.surnameHolder.setText(currentContact.getSurname());
        vh.numberHolder.setText(currentContact.getNumber());
    }

    class ViewHolder {
        TextView nameHolder, surnameHolder, numberHolder;

        public ViewHolder(View view) {

            nameHolder = view.findViewById(R.id.tvName);
            surnameHolder = view.findViewById(R.id.tvSurname);
            numberHolder = view.findViewById(R.id.tvPhone);
        }
    }

}
