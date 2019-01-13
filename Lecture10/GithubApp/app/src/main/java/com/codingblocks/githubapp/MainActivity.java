package com.codingblocks.githubapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
                networkTask.execute("https://api.github.com/search/users?q=" + etUrl.getText().toString());
            }
        });

    }

    class NetworkTask extends AsyncTask<String, Void, ArrayList<GithubUser>> {

        @Override
        protected ArrayList<GithubUser> doInBackground(String... strings) {

            String url = strings[0];

            String response = makeNetworkCall(url);

            ArrayList<GithubUser> users = parseJson(response);

            return users;
        }

        @Override
        protected void onPostExecute(ArrayList<GithubUser> githubUsers) {
            super.onPostExecute(githubUsers);

            Log.e("TAG", githubUsers.get(1).getLogin());
        }
    }

    public String makeNetworkCall(String s) {

        try {
            URL url = new URL(s);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

//            httpURLConnection.setRequestMethod("GET");
//
//            httpURLConnection.setConnectTimeout(3000);

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

    public ArrayList<GithubUser> parseJson(String json) {
        ArrayList<GithubUser> githubUsers = new ArrayList<>();

        //Parse the json and extract the users
        //Add the extracted user to the above arrayList

        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONArray itemsArray = jsonObject.getJSONArray("items");

            for (int i = 0; i < itemsArray.length(); i++) {

                JSONObject currentObject = itemsArray.getJSONObject(i);

                String login = currentObject.getString("login");
                String profileImage = currentObject.getString("avatar_url");
                String profileUrl = currentObject.getString("html_url");
                String score = currentObject.getString("score");

                GithubUser githubUser = new GithubUser(login, profileUrl, score, profileImage);

                githubUsers.add(githubUser);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("TAG", "parseJson: The json is invalid : " + json);
        }
        return githubUsers;
    }

}
