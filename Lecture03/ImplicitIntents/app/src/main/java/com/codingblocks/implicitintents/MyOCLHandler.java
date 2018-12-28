package com.codingblocks.implicitintents;

import android.content.Intent;
import android.view.View;

public class MyOCLHandler implements View.OnClickListener {

    Intent i;

    int integer;

    public void setI(int i) {
        this.integer = i;
    }

    @Override
    public void onClick(View v) {
//        startActivity(i);
    }
}
