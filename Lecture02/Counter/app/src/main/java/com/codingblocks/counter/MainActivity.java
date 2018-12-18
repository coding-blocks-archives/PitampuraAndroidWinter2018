package com.codingblocks.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    private final String TAG = getClass().getSimpleName();
    TextView countText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countText = findViewById(R.id.counterTV);
    }

    public void decrement(View view) {
        if (count > 0)
            count--;

//        Button b = (Button) view;
//        b.setText("New Button");

        countText.setText("" + count);

        Log.d(TAG, "" + count);
    }

    public void increment(View view) {
        count++;

//        TextView countText = findViewById(R.id.counterTV);
        countText.setText("" + count);

        Log.d(TAG, "" + count);
    }
}
