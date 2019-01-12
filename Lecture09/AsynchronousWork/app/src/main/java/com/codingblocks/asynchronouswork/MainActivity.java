package com.codingblocks.asynchronouswork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStart);
        final TextView tvDone = findViewById(R.id.tvDone);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (long i = 0; i < 100000000L; i++) {
                            //Do nothing
                        }

                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvDone.setText("Counting Done!");
                            }
                        });
//                        tvDone.setText("Counting Done!");
//                        Toast.makeText(MainActivity.this, "Counting Done", Toast.LENGTH_SHORT).show();
                    }
                });

                t.start();

            }
        });
    }
}
