package com.codingblocks.onclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etMain;
    TextView tvMain;
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);
        btnShow = findViewById(R.id.btnShow);


        etMain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvMain.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };

        btnShow.setOnClickListener(ocl);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnShow.setOnClickListener(new OnClickImpl());

        btnShow.setOnClickListener(this);
//        btnMul.setOnClickListener(this);
//        btnDiv.setOnClickListener(this);
//        btnAdd.setOnClickListener(this);
    }

    public void showInput(View view) {

        String input = etMain.getText().toString();
        tvMain.setText(input);

//        String inputEt = etMain.getText();
//
//        String inpu = (String) tvMain.getText();

    }

    @Override
    public void onClick(View v) {

//        switch (v.getId()) {
//            case R.id.btnMum:
//                doMultiply();
//                break;
//            case R.id.div:
//                doDivide();
//                break;
//        }

    }
}
