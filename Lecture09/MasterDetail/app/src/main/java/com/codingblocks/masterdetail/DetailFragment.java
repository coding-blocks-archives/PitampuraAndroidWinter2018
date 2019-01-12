package com.codingblocks.masterdetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    String title, subTitle;

    public static DetailFragment newInstance(Note note) {

        Bundle args = new Bundle();

        args.putSerializable("N", note);

//        args.putString("T",title);
//        args.putString("S",subTitle);

        DetailFragment fragment = new DetailFragment();

        fragment.setArguments(args);

        return fragment;
    }


    public DetailFragment() {
    }

//    public DetailFragment(String title, String subTitle) {
//        this.title = title;
//        this.subTitle = subTitle;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();

        Note n = (Note) bundle.getSerializable("N");
        title = n.getTitle();
        subTitle = n.getSubtitle();

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
