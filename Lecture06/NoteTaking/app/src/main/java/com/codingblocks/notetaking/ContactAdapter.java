package com.codingblocks.notetaking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private ArrayList<Contact> contacts;
    private Context context;

    public ContactAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemId) {
        LayoutInflater li = LayoutInflater.from(context);

        context = viewGroup.getContext();

        View inflatedView = li.inflate(R.layout.item_row, viewGroup, false);

        return new ContactHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactHolder contactHolder, int position) {
        final Contact currentContact = contacts.get(position);

        contactHolder.nameHolder.setText(currentContact.getName());
        contactHolder.surnameHolder.setText(currentContact.getSurname());
        contactHolder.numberHolder.setText(currentContact.getNumber());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView nameHolder, surnameHolder, numberHolder;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);  //FYI itemView is your LinearLayout ;)
            nameHolder = itemView.findViewById(R.id.tvName);
            surnameHolder = itemView.findViewById(R.id.tvSurname);
            numberHolder = itemView.findViewById(R.id.tvPhone);
            linearLayout = itemView.findViewById(R.id.parentLayout);

            linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    contacts.remove(getAdapterPosition());  //Alternate way to get the current position
                    notifyItemRemoved(getAdapterPosition());
                    return false;
                }
            });
        }
    }

}
