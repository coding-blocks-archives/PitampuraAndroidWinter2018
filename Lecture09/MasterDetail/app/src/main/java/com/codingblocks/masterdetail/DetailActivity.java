package com.codingblocks.masterdetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();

        Note n = (Note) i.getSerializableExtra("N");

//        String title = i.getStringExtra("T");
//        String subTitle = i.getStringExtra("S");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container2,
                        DetailFragment.newInstance(n))
                .commit();
    }
}
