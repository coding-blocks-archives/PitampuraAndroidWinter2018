package com.codingblocks.heterogeneousadapter;

import android.os.Message;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Object> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageList.add(new ReceivedMessage("Hello"));
        messageList.add(new ReceivedMessage("Sup?"));
        messageList.add(new SentMessage("I'm good!"));
        messageList.add(new ReceivedMessage("Happy New Year"));
        messageList.add(new SentMessage("K"));
        messageList.add(new SentMessage("Same to you"));
        messageList.add(new ReceivedMessage("Hello"));
        messageList.add(new ReceivedMessage("Sup?"));
        messageList.add(new SentMessage("I'm good!"));
        messageList.add(new ReceivedMessage("Happy New Year"));
        messageList.add(new SentMessage("K"));
        messageList.add(new SentMessage("Same to you"));
        messageList.add(new ReceivedMessage("kkk"));
        messageList.add(new ReceivedMessage("kk"));
        messageList.add(new SentMessage("Yo!!!"));
        messageList.add(new SentMessage("Aight"));
        messageList.add(new ReceivedMessage("lol"));
        messageList.add(new ReceivedMessage("k"));

        RecyclerView recyclerView = findViewById(R.id.rvMessage);
        MessageAdapter messageAdapter = new MessageAdapter(messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(messageAdapter);
    }
}
