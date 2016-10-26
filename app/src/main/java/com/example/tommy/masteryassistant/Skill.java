package com.example.tommy.masteryassistant;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Nathan on 10/10/2016.
 */

public class Skill {

    private int _id;
    private String _name;
    private int _timeCompleted;
    private int _desiredMasteryLevel;
    private int _weeklyGoal;
    private int _weeklyGoalProgress;
    private int _weeklyGoalStarted;

    public Skill(){

    }

    public Skill(String _name, int _timeCompleted, int _desiredMasteryLevel, int _weeklyGoal) {
        this._name = _name;
        this._timeCompleted = _timeCompleted;
        this._desiredMasteryLevel = _desiredMasteryLevel;
        this._weeklyGoal = _weeklyGoal;
        this._weeklyGoalProgress = 0;
         this._weeklyGoalStarted = 2;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_timeCompleted(int _timeCompleted) {
        this._timeCompleted = _timeCompleted;
    }

    public void set_desiredMasteryLevel(int _desiredMasteryLevel) {
        this._desiredMasteryLevel = _desiredMasteryLevel;
    }

    public int get_weeklyGoal() {
        return _weeklyGoal;
    }

    public void set_weeklyGoal(int _weeklyGoal) {
        this._weeklyGoal = _weeklyGoal;
    }

    public int get_weeklyGoalProgress() {
        return _weeklyGoalProgress;
    }

    public void set_weeklyGoalProgress(int _weeklyGoalProgress) {
        this._weeklyGoalProgress = _weeklyGoalProgress;
    }

    public int get_weeklyGoalStarted() {
        return _weeklyGoalStarted;
    }

    public void set_weeklyGoalStarted(int _weeklyGoalStarted) {
        this._weeklyGoalStarted = _weeklyGoalStarted;
    }

    public String get_name() {
        return _name;
    }

    public int get_timeCompleted() {
        return _timeCompleted;
    }

    public int get_desiredMasteryLevel() {
        return _desiredMasteryLevel;
    }

}