package com.codingblocks.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etUrl;
    Button btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrl = findViewById(R.id.etUrl);
        btnView = findViewById(R.id.btnClick);

//        String url = etUrl.getText().toString();

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String url = "tel:" + etUrl.getText().toString();
//
//                Uri uriToView = Uri.parse(url);
//
//                //tel:9968195588
//
//                Intent i = new Intent();
//
//                i.setAction(Intent.ACTION_DIAL);
//
//                i.setData(uriToView);
//
//                startActivity(i);

                Intent i = new Intent();
                i.setAction("xyz");


//                i.putExtra("NAME", )

                startActivity(i);
            }
        });

    }
}
