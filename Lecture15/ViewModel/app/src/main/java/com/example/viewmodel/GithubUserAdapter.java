package com.example.viewmodel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserAdapter.UserHolder> {

    private ArrayList<GithubUser> githubUsers;

    public GithubUserAdapter(ArrayList<GithubUser> githubUsers) {
        this.githubUsers = githubUsers;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new UserHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder userHolder, int i) {
        GithubUser user = githubUsers.get(i);

//        Log.e("TAG",user.toString());

        userHolder.tvLogin.setText(user.getLogin());
        userHolder.tvScore.setText(user.getScore().toString());

        Gson gson = new Gson();

        String jsonUser = gson.toJson(user);

        //Start the intent
        //call putExtra() with the string jsonUser

    }

    @Override
    public int getItemCount() {
        return githubUsers.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {

        TextView tvScore, tvLogin;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            tvScore = itemView.findViewById(R.id.tvScore);
            tvLogin = itemView.findViewById(R.id.tvLogin);
        }
    }
}
