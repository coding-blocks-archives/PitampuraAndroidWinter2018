package com.codingblocks.networking;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = findViewById(R.id.tvContent);
        Button btnSend = findViewById(R.id.btnFetch);

        final EditText etUrl = findViewById(R.id.etUrl);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Execute the AsyncTask

                NetworkTask networkTask = new NetworkTask();
                networkTask.execute(etUrl.getText().toString());
            }
        });

    }

    class NetworkTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String url = strings[0];
            String result = makeNetworkCall(url);
            //Make the network request
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvContent.setText(s);
        }
    }

    public String makeNetworkCall(String s) {

        try {
            URL url = new URL(s);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");

            httpURLConnection.setConnectTimeout(3000);

            InputStream is = httpURLConnection.getInputStream();

            Scanner scanner = new Scanner(is);

            //This allows the scanner to read the entire file content in one go
            scanner.useDelimiter("\\A");

            String result = "";

            if (scanner.hasNext()) {
                result = scanner.next();
            }

            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("TAG", "makeNetworkCall: Incorrect URL : " + s);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Some unexpected error occurred!";

    }

}
