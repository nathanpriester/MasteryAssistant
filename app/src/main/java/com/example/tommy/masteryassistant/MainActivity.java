package com.example.tommy.masteryassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
/* testing github from nathans laptop with this comment */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Functional Button
    public void onButton_Create_Skills(View v) {

        if(v.getId() == R.id.button_createskill) {
            Intent create = new Intent(MainActivity.this, Create_Skills.class);
            startActivity(create);
        }

    }
    public void onButton_Skill_Hub(View v) {

        if(v.getId() == R.id.button_skillhub) {
            Intent hub = new Intent(MainActivity.this, Skill_Hub.class);
            startActivity(hub);
        }

    }
    public void onButton_Milestones(View v) {

        if(v.getId() == R.id.button_milestones) {
            Intent milestone1 = new Intent(MainActivity.this, Milestones.class);
            startActivity(milestone1);
        }

    }
    public void onButton_View_Skills(View v) {

        if(v.getId() == R.id.button_viewskills) {
            Intent viewskills = new Intent(MainActivity.this, View_Skills.class);
            startActivity(viewskills);
        }

    }
    public void onButton_Progress(View v) {

        if(v.getId() == R.id.button_progress) {
            Intent prog = new Intent(MainActivity.this, Progress.class);
            startActivity(prog);
        }

    }
    public void onButton_Settings(View v) {

        if(v.getId() == R.id.button_settings) {
            Intent settings1 = new Intent(MainActivity.this, Settings.class);
            startActivity(settings1);
        }

    }
}
