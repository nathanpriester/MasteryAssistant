package com.example.tommy.masteryassistant;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Created by Danie_000 on 10/14/2016.
 */

public class Share extends AppCompatActivity {

    // Starts and shows activity_share.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
    }

    // Default onCreateOptionsMenu
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R..menu.menu_about_contacts., menu);
        return true;
    }
*/

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share, menu);
        // return super.onCreateOptionsMenu(menu);
        return true;

    }
/*
    // Determines if Action bar item was selected. If true then do corresponding action.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.activity_share:
                startActivity(new Intent(this, Share.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
   */
}

