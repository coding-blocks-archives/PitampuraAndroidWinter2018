package com.codingblocks.heterogeneousadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Object> messages;
    Context context;
    private static final int ID_SENT = 1;
    private static final int ID_RECEIVED = 2;
    private static final int ID_NONE = 0;

    public MessageAdapter(ArrayList<Object> messages) {
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        Object currentObj = messages.get(position);

        if (currentObj instanceof ReceivedMessage) {
            return ID_RECEIVED;
        } else if (currentObj instanceof SentMessage) {
            return ID_SENT;
        } else
            return ID_NONE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int id) {

        context = viewGroup.getContext();

        LayoutInflater li = LayoutInflater.from(context);

        if (id == ID_SENT) {
            View sentView = li.inflate(R.layout.item_sent, viewGroup, false);
            return new SentHolder(sentView);
            //Inflate and return sent

        } else if (id == ID_RECEIVED) {
            View receivedView = li.inflate(R.layout.item_received, viewGroup, false);
            return new ReceivedHolder(receivedView);
            //Inflate and return received

        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int currentObjectsId = getItemViewType(position);

        if (currentObjectsId == ID_SENT) {

            SentMessage sentMessage = (SentMessage) messages.get(position);
            SentHolder sentHolder = (SentHolder) viewHolder;

            sentHolder.tvSent.setText(sentMessage.getMessage());
        } else if (currentObjectsId == ID_RECEIVED) {

            ReceivedMessage receivedMessage = (ReceivedMessage) messages.get(position);
            ReceivedHolder receivedHolder = (ReceivedHolder) viewHolder;

            receivedHolder.tvReceived.setText(receivedMessage.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class SentHolder extends RecyclerView.ViewHolder {

        TextView tvSent;

        public SentHolder(@NonNull View itemView) {
            super(itemView);
            tvSent = itemView.findViewById(R.id.tvSent);
        }
    }

    class ReceivedHolder extends RecyclerView.ViewHolder {

        TextView tvReceived;

        public ReceivedHolder(@NonNull View itemView) {
            super(itemView);
            tvReceived = itemView.findViewById(R.id.tvReceived);
        }
    }

}
