package com.example.tommy.masteryassistant;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tommy on 9/27/2016.
 */

public class View_Skills extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Skill> skills_array = new ArrayList<Skill>();
    ArrayList<String> skills = new ArrayList<String>();
    ArrayList<String> hours = new ArrayList<String>();
    Context mContext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_skills);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        DBHandler dbHandler = new DBHandler(this);
        SQLiteDatabase sqLiteDatabase = dbHandler.getReadableDatabase();

        Cursor cursor = dbHandler.getInformation(sqLiteDatabase);

        cursor.moveToFirst();
        do {
            String skillName = cursor.getString(0);
            int hours_as_int = cursor.getInt(1);
            int desiredMastery = cursor.getInt(2);
            int weeklyGoal = cursor.getInt(3);
            Skill skill_in_db = new Skill(skillName,hours_as_int,desiredMastery,weeklyGoal);
            skills_array.add(skill_in_db);
            Skill skilli = skills_array.get(0);
        }while (cursor.moveToNext());
        dbHandler.close();

        mAdapter = new MyAdapter(skills_array,this);
        mRecyclerView.setAdapter(mAdapter);

        SharedPreferences preferences = getSharedPreferences("PREFERENCES", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("current_skill", "guitar");
        editor.commit();
    }
}