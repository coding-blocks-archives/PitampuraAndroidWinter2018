package com.codingblocks.listviewcustomadapter;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.View;

public class MockAppCompatActivity {

    private View inflatedView;

    void setContentView(@LayoutRes int id) {
        //inflate and initialize inflatedView
    }

    View findViewById(@IdRes int id) {
        View foundView = inflatedView.findViewById(id);
        return foundView;
    }

}
