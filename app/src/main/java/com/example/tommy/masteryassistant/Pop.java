package com.example.tommy.masteryassistant;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by Danie_000 on 11/19/2016.
 */
public class Pop extends Activity {
    private TextView level_complete;
    private TextView rank_complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);
        level_complete = (TextView)findViewById(R.id.levelComplete);
        rank_complete = (TextView) findViewById(R.id.rankComplete);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .6));
    }
}