package com.example.tommy.masteryassistant;

import android.content.Context;

/**
 * Created by Danie_000 on 10/5/2016.
 */

public class Chronometer implements Runnable {
    public static final long MILIS_TO_SECONDS = 1000;
    public static final long MILIS_TO_MINUTES = 60000;
    public static final long MILIS_TO_HOURS = 3600000;

    private Context mContext;
    private long mStartTime;

    public Chronometer(Context mContext) {
        this.mContext = mContext;
    }

    private boolean mIsRunning;

    public void start( ) {
        mStartTime = System.currentTimeMillis();
        mIsRunning = true;
    }

    public void stop(){
        mIsRunning = false;
    }

    @Override
    public void run() {

        while(mIsRunning){

            long since = System.currentTimeMillis() - mStartTime;

            int seconds = (int) ((since / 1000) % 60);
            int minutes = (int) ((since / MILIS_TO_MINUTES) % 60);
            int hours = (int) ((since / MILIS_TO_HOURS) % 24);

            ((Skill_Hub)mContext).updateTimerText(String.format(
                    "%02d : %02d : %02d", hours, minutes, seconds));

            //Sleep the thread for a short amount, to prevent high CPU usage!
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
