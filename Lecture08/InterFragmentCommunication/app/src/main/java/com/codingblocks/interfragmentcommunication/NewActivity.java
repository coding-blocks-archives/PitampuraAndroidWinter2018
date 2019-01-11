package com.codingblocks.interfragmentcommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        Intent intent = getIntent();


        String title = intent.getStringExtra("TITLE");
        String subTitle = intent.getStringExtra("SUBTITLE");

//        Bundle intentBundle = intent.getExtras();


//        Bundle bundle = new Bundle();
//        bundle.putString("T", title);
//        bundle.putString("S", subTitle);

//        bundle.putAll(intentBundle);

//        NewFragment newFragment = new NewFragment();
//        newFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container2,
                        NewFragment.newInstance(title,subTitle))
                .commit();
    }

//    public NewFragment newInstance(String title, String subTitle) {
//
//        Bundle args = new Bundle();
//
//        args.putString("T",title);
//        args.putString("S",subTitle);
//
//        NewFragment fragment = new NewFragment();
//
//        fragment.setArguments(args);
//
//        return fragment;
//    }

}
