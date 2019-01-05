package com.codingblocks.dynamicfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.btnAdd);

        final FragmentManager fragmentManager = getSupportFragmentManager();

//        MyFragment myFragment = (MyFragment) fragmentManager.findFragmentByTag("FIRST_INSTANCE");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add a new Fragment dynamically

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

//                fragmentTransaction.add(new MyFragment(), "FIRST_INSTANCE");

//                fragmentTransaction.add(R.id.container,new MyFragment());

//                fragmentTransaction.add(R.id.container,new MyFragment(),"A_UNIQUE_TAG");

                fragmentTransaction.replace(R.id.container, new MyFragment(), "UNIQUE_TAG");

                fragmentTransaction.commit();
            }
        });

    }
}
