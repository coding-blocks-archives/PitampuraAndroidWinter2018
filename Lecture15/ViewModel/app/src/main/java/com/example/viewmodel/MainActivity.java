package com.example.viewmodel;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GithubUserAdapter userAdapter;
    ArrayList<GithubUser> githubUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userAdapter = new GithubUserAdapter(githubUsers);
        RecyclerView githubUsersRecyclerView = findViewById(R.id.rvUsers);
        githubUsersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        githubUsersRecyclerView.setAdapter(userAdapter);

        GithubViewModel githubViewModel = ViewModelProviders.of(this).get(GithubViewModel.class);

        ArrayList<GithubUser> users = githubViewModel.getUsers("https://api.github.com/search/users?q=harshit");

        githubUsers.addAll(users);
        userAdapter.notifyDataSetChanged();
    }

}
