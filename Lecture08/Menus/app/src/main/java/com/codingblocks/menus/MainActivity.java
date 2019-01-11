package com.codingblocks.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                Toast.makeText(this, "Clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_home:
                Toast.makeText(this, "Clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_profile:
                Toast.makeText(this, "Clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_settings:
                Toast.makeText(this, "Clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }
}
