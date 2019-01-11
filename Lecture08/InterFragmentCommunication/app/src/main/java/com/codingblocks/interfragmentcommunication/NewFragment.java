package com.codingblocks.interfragmentcommunication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewFragment extends Fragment {

    String title, subTitle;

    public static NewFragment newInstance(String title, String subTitle) {

        Bundle args = new Bundle();

        args.putString("T",title);
        args.putString("S",subTitle);

        NewFragment fragment = new NewFragment();

        fragment.setArguments(args);

        return fragment;
    }


    public NewFragment() {
    }

//    public NewFragment(String title, String subTitle) {
//        this.title = title;
//        this.subTitle = subTitle;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        title = bundle.getString("T");
        subTitle = bundle.getString("S");

        return inflater.inflate(R.layout.fragment_new, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvTitle = view.findViewById(R.id.tvFragTitle);
        TextView tvSubtitle = view.findViewById(R.id.tvFragSubTitle);

        tvTitle.setText(title);
        tvSubtitle.setText(subTitle);
    }
}
