package com.example.tommy.masteryassistant;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tommy on 9/27/2016.
 */

public class Skill_Hub extends AppCompatActivity {
    private TextView mTvTime;
    private Button mBtnStart;
    private Button mBtnLap;
    private Button mBtnStop;
    private Context mContext;
    private Chronometer mChronometer;
    private Thread mThreadChrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skill_hub);

        mContext = this;

        mTvTime = (TextView) findViewById(R.id.tv_time);
        mBtnStart = (Button) findViewById(R.id.btn_start);
        //mBtnLap = (Button) findViewById(R.id.btn_lap);
        mBtnStop = (Button) findViewById(R.id.btn_stop);

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
    }

    public void updateTimerText(final String time) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTvTime.setText(time);
            }
        });
    }
}
