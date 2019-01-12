package com.codingblocks.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStart = findViewById(R.id.btnStart);
        progressBar = findViewById(R.id.progressBar);

        final CountTask countTask = new CountTask();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countTask.getStatus().equals(AsyncTask.Status.FINISHED))
                    countTask.execute(10000000L, 200000000L, 4000000000000L);
            }
        });
    }

    class CountTask extends AsyncTask<Long, Integer, String> {

        //Main thread
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        //Background thread
        @Override
        protected String doInBackground(Long... longs) {

            Long thirdValue = longs[0];

            for (long i = 0; i < thirdValue; i++) {
                //Do something
                if (i % 1000000 == 0) publishProgress((int) i);
            }

            return "Counting Done";
        }

        //Main Thread
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Toast.makeText(MainActivity.this, "Counted till : " + values[0], Toast.LENGTH_SHORT).show();
        }

        //Main Thread
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }

}
