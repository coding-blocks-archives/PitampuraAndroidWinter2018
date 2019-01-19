package com.codingblocks.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    GithubUserAdapter userAdapter;
    ArrayList<GithubUser> githubUsers = new ArrayList<>();


    // function names startWithALowerCaseLetterAndAlternaterWordsHaveFirstCapitalLetter
    // variable names startWithALowerCaseLetterAndAlternaterWordsHaveFirstCapitalLetter
    // class names startWithAnUpperCaseLetterAndAlternaterWordsHaveFirstCapitalLetter
    // No _ or numbers preferred while naming
    // Variable and class names should be descriptive

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userAdapter = new GithubUserAdapter(githubUsers);
        RecyclerView githubUsersRecyclerView = findViewById(R.id.rvUsers);
        githubUsersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        githubUsersRecyclerView.setAdapter(userAdapter);

        makeNetworkCall("https://api.github.com/search/users?q=harshit");
    }

    public void makeNetworkCall(String url) {
        //Make the network call and add data to the adapter

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

//        Call myCall = client.newCall(request);


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //Add a breaking condition for this retry mechanism
//                call.enqueue(this);
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200) {
                    String jsonResponse = response.body().string();

                    Gson gson = new Gson();

                    GithubResponse githubResponse = gson.fromJson(jsonResponse, GithubResponse.class);

                    githubUsers.addAll(githubResponse.getItems());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            userAdapter.notifyDataSetChanged();
                        }
                    });

                    Log.e("TAG", jsonResponse);
                }
            }
        });

    }

}
