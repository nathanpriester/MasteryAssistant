package com.example.tommy.masteryassistant;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.DonutProgress;
import com.plattysoft.leonids.ParticleSystem;

import java.util.ArrayList;
import java.util.prefs.*;

/**
 * Created by Tommy on 9/27/2016.
 */

public class Skill_Hub extends Activity {
    private TextView mTvTime;
    private Button mBtnStart;
    private Button mBtnLap;
    private Button mBtnStop;
    private Context mContext;
    private Chronometer mChronometer;
    private Thread mThreadChrono;

    TextView SKILL_NAME;
    TextView WEEKLY_GOAL;
    TextView hours_to_weekly_g;
    TextView minutes_to_weekly_g;
    TextView seconds_to_weekly_g;
    TextView CURRENT_LEVEL;
    TextView hours_to_level;
    TextView minutes_to_level;
    TextView seconds_to_level;
    TextView milestone_rank;
    ProgressBar weekly_Progress_Bar;
    ProgressBar current_M_Progress_Bar;
    private DonutProgress donutProgress_skillhub;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skill_hub);

        mContext = this;

        mTvTime = (TextView) findViewById(R.id.tv_time);
        mBtnStart = (Button) findViewById(R.id.btn_start);
        //mBtnLap = (Button) findViewById(R.id.btn_lap);
        mBtnStop = (Button) findViewById(R.id.btn_stop);

        SKILL_NAME = (TextView) findViewById(R.id.Skill_name_hub);
        WEEKLY_GOAL = (TextView) findViewById(R.id.Weekly_goal_title);
        hours_to_weekly_g = (TextView) findViewById(R.id.weekly_goal_hours);
        minutes_to_weekly_g = (TextView) findViewById(R.id.weekly_minutes);
        seconds_to_weekly_g = (TextView) findViewById(R.id.weekly_seconds);
        CURRENT_LEVEL = (TextView) findViewById(R.id.cur_m_title);
        hours_to_level = (TextView) findViewById(R.id.tot_hours_forCM);
        minutes_to_level = (TextView) findViewById(R.id.tot_minutes_forCM);
        seconds_to_level = (TextView) findViewById(R.id.tot_seconds_forCM);
        milestone_rank = (TextView) findViewById(R.id.Rank_Skillhub);
        weekly_Progress_Bar = (ProgressBar) findViewById(R.id.weekly_Progressbar);
        current_M_Progress_Bar = (ProgressBar) findViewById(R.id.cur_m_progressbar);
        donutProgress_skillhub = (DonutProgress) findViewById(R.id.donut_Skillhub);

        //Get skill data bassed off preference NEEDS TO BE IMPLEMENTED *current retrieval temporary
        String currentSkill = Preferences.getCurrentSkill(this);
        SKILL_NAME.setText(currentSkill);
        DBHandler dbHandler = new DBHandler(this);
        SQLiteDatabase sqLiteDatabase = dbHandler.getReadableDatabase();
        Cursor cursor = dbHandler.getInformation(sqLiteDatabase);
        cursor.moveToFirst();

        //get cursor to point to Current Skill
        while (!cursor.getString(0).equals(currentSkill)){
            cursor.moveToNext();
        }

        int seconds_as_int = cursor.getInt(1);
        int weeklygoal_hours_asSeconds = cursor.getInt(3) * 3600;
        dbHandler.close();

        //process data from database - seconds to respective title
        int total_hours = seconds_as_int / 3600;
        int leftOver_minutes = (seconds_as_int % 3600) / 60;
        int leftOver_seconds = ((seconds_as_int % 3600) % 60);

        //set total hours minutes seconds text under MilestoneLevel
        hours_to_level.setText(Integer.toString(total_hours) + " Hours");
        minutes_to_level.setText(Integer.toString(leftOver_minutes) + " Minutes");
        seconds_to_level.setText(Integer.toString(leftOver_seconds) + " Seconds");


        /*
        * RE- Create Milestone_objects, Milestone_collections, SETS_of_Milestone_Collections
        * Each Milestone collection is a collection of Milestone_Objects
        * SET_of_Milestone_Collections is a collection of milestone_collections
        *
        * Milestones are organized this way to be passed into Milestone adaptor as a SET of Milestone_collections
        * Adaptor will extract info from each milestone_collection and use it per each card in RecyclerView
        * */

        // IF bugs happen check this array
        int[] milestone_collection_totalHours = {35, 180, 425, 770, 1215, 1760, 2405, 3150, 3995, 4940, 5985, 7130,
                8375, 9270, 10000};
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

        /*
        * Determine which level to display on skill hub! compared total seconds to seconds
        * required to complete each level
        * */

        //milestone_collection now represents the collection of ranks within our current level
        int level_total_time = 10000;
        for (int i = 0; i < 14; i++){
            if (seconds_as_int < (milestone_collection_totalHours[i] * 3600)){
                milestone_collection = SET_of_milestoneCollections.get(i);
                level_total_time = milestone_collection_totalHours[i];
                break;
            }
        }


        /*
        * SET TEXT on screen relevant to milestone level
        * */
        CURRENT_LEVEL.setText(milestone_collection.getLevel() + " - " + Integer.toString(level_total_time) + " Hours");

        //GET MILESTONE RANK data
        //milestone now pertaints to milestone in milestone collection
        //initialize with last milestone in case total seconds not less than an 10000 hours as seconds

        milestone = milestone_collection.getMilestones_set().get(milestone_collection.size() - 1);
        for(int i = 0; i < milestone_collection.size(); i++){
            if (seconds_as_int < milestone_collection.getMilestones_set().get(i).getFill_time()){
                milestone = milestone_collection.getMilestones_set().get(i);
                break;
            }
        }

        //SET TEXT on creen relevant to rank
        milestone_rank.setText("Rank " + milestone.getRank() + " - " + Integer.toString(milestone.getFill_time() / 3600)
                + " Hours");

        //SET Level Progress bar
        if (seconds_as_int >= level_total_time * 3600){
            current_M_Progress_Bar.setProgress(100);
        }
        else {
            current_M_Progress_Bar.setProgress((int)(((double) (seconds_as_int) / (double) (level_total_time * 3600)) * 100));
        }


        //SET donut progress
        if (seconds_as_int >= milestone.getFill_time()){
            donutProgress_skillhub.setProgress(100);
        }
        else {
            donutProgress_skillhub.setProgress((int)(((double) (seconds_as_int) / (double) milestone.getFill_time()) * 100));
        }

        /*
        * GET AND SET DATA for WeeklyGoal
        * */

        WEEKLY_GOAL.setText("Weekly Goal - " + Integer.toString(weeklygoal_hours_asSeconds / 3600) + " Hours");





        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mChronometer == null){
                    mChronometer = new Chronometer(mContext);
                    mThreadChrono = new Thread(mChronometer);
                    mThreadChrono.start();
                    mChronometer.start();
                }
            }
        });

        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mChronometer != null) {
                    mChronometer.stop();
                    mThreadChrono.interrupt();
                    mThreadChrono = null;

                    mChronometer = null;
                }
            }
        });

        /*
        new ParticleSystem(this, 80, R.drawable.confeti2, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 180, 180)
                .setRotationSpeed(144)
                .setAcceleration(0.00005f, 90)
                .emit(findViewById(R.id.weekly_seconds), 8);

        new ParticleSystem(this, 80, R.drawable.confeti3, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                .setRotationSpeed(144)
                .setAcceleration(0.00005f, 90)
                .emit(findViewById(R.id.weekly_seconds), 8);
         */
    }

    public void updateTimerText(final String time, final String totalHours, final String totalMinutes, final String totalSeconds) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTvTime.setText(time);
                seconds_to_level.setText(totalSeconds);
                minutes_to_level.setText(totalMinutes);
                hours_to_level.setText(totalHours);

            }
        });
    }

    public void updateText_time_milestones(final String hours, final String minuts, final String seconds) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    public void onBackPressed(){
        if(mChronometer != null) {
            mChronometer.stop();
            mThreadChrono.interrupt();
            mThreadChrono = null;

            mChronometer = null;
        }
        Toast.makeText(getBaseContext(), "Timer Stopped", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
}