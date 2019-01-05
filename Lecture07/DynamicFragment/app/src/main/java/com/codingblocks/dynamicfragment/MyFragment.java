package com.codingblocks.dynamicfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    TextView tvCount;
    Button btnIncrement, btnDecrement;
    Integer count = 0;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvCount = view.findViewById(R.id.tvName);
        btnIncrement = view.findViewById(R.id.btnIncrement);
        btnDecrement = view.findViewById(R.id.btnDecrement);

        tvCount.setText(count.toString());

        btnDecrement.setOnClickListener(this);
        btnIncrement.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIncrement:
                count++;
                tvCount.setText(count.toString());
                break;

            case R.id.btnDecrement:
                count--;
                tvCount.setText(count.toString());
                break;
        }
    }
}
