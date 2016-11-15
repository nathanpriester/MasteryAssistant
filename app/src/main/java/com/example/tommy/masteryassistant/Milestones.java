package com.example.tommy.masteryassistant;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tommy on 9/27/2016.
 */

public class Milestones extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Skill> skills_array = new ArrayList<Skill>();
    ArrayList<String> skills = new ArrayList<String>();
    ArrayList<String> hours = new ArrayList<String>();
    private TextView actionbar_seconds;
    private TextView actionbar_minutes;
    private TextView actionbar_hours;
    private int seconds_actionbar;
    private int minutes_actionbar;
    private int hours_actionbar;
    private ProgressBar actionbar_Progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.milestones);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view2);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        //Get skill data bassed off preference NEEDS TO BE IMPLEMENTED *current retrieval temporary
        DBHandler dbHandler = new DBHandler(this);
        SQLiteDatabase sqLiteDatabase = dbHandler.getReadableDatabase();
        Cursor cursor = dbHandler.getInformation(sqLiteDatabase);
        cursor.moveToFirst();
        int seconds_as_int = cursor.getInt(1);
        dbHandler.close();

        //find time actionbar IDs
        TextView actionbar_seconds = (TextView)findViewById(R.id.seconds_actionbar);
        TextView actionbar_minutes = (TextView)findViewById(R.id.minutes_actionbar);
        TextView actionbar_hours = (TextView)findViewById(R.id.hours_actionbar);

        // set action bar total skill hours, minutes, seconds
        hours_actionbar = seconds_as_int / 3600;
        minutes_actionbar = (seconds_as_int % 3600) / 60;
        seconds_actionbar = ((seconds_as_int % 3600) % 60);

        //set time texts in actionbar
        actionbar_hours.setText(Integer.toString(hours_actionbar) + " Hours");
        actionbar_minutes.setText(Integer.toString(minutes_actionbar) + " Minutes");
        actionbar_seconds.setText(Integer.toString(seconds_actionbar) + " Seconds");

        //set progressbar in actionbar
        actionbar_Progress = (ProgressBar)findViewById(R.id.m_Progressbar_action);
        actionbar_Progress.setProgress((int)(((double) seconds_as_int / 36000000) * 100));

        /*
        * Create Milestone_objects, Milestone_collections, SETS_of_Milestone_Collections
        * Each Milestone collection is a collection of Milestone_Objects
        * SET_of_Milestone_Collections is a collection of milestone_collections
        *
        * Milestones are organized this way to be passed into Milestone adaptor as a SET of Milestone_collections
        * Adaptor will extract info from each milestone_collection and use it per each card in RecyclerView
        * */

        int milestone_min_time = 0;
        int n = 5;
        int milestone_fil_time = n * 3600;
        String[] Beginner_ranks = {"I", "II", "III", "IV", "V"};
        String[] General_ranks = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] General_levels = {"Novice", "Rookie", "Apprentice", "Talented", "Skilled", "Adept", "Skillful", "Seasoned",
                "Proficient", "Experienced", "Advanced", "Senior", "Expert", "Mastery"};
        Milestone_Collection milestone_collection = new Milestone_Collection();
        milestone_collection.setLevel("Beginner");
        ArrayList<Milestone_Collection> SET_of_milestoneCollections = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            Milestone_Object milestone = new Milestone_Object(seconds_as_int, milestone_min_time, milestone_fil_time, Beginner_ranks[i]);
            //update values
            milestone_min_time = milestone_fil_time;
            n++;
            milestone_fil_time += n * 3600;
            milestone_collection.addMilestone(milestone);
        }

        SET_of_milestoneCollections.add(milestone_collection);

        for(int i = 0; i < 13; i++){
            //create new milestone collection
            milestone_collection = new Milestone_Collection();
            milestone_collection.setLevel(General_levels[i]);

            //create 10 appropriate milestone objects - insert into collection
            for(int j = 0; j < 10; j++){
                Milestone_Object milestone = new Milestone_Object(seconds_as_int, milestone_min_time, milestone_fil_time, General_ranks[j]);
                //update values
                milestone_min_time = milestone_fil_time;
                n++;
                milestone_fil_time += n * 3600;
                milestone_collection.addMilestone(milestone);
            }

            //add milestone_collection to SET
            SET_of_milestoneCollections.add(milestone_collection);
        }

        //add Master Milestone to collection and then SET
        milestone_collection = new Milestone_Collection();
        milestone_collection.setLevel("Mastery");
        milestone_fil_time += n * 3600;
        Milestone_Object milestone = new Milestone_Object(seconds_as_int, milestone_min_time, milestone_fil_time, "I");
        milestone_collection.addMilestone(milestone);
        SET_of_milestoneCollections.add(milestone_collection);

        //add SET to adaptor. Set recyclerview adapter.
        mAdapter = new Milestone_adapter(SET_of_milestoneCollections);
        mRecyclerView.setAdapter(mAdapter);
    }
}