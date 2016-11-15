package com.example.tommy.masteryassistant;

/**
 * Created by Danie_000 on 10/28/2016.
 */

public class Milestone_Object {

    //time is in seconds
    private int current_time;
    private int min_time;
    private int fill_time;
    private String Level;
    private String rank;

    public Milestone_Object(int current_time, int min_time, int fill_time, String rank) {
        this.current_time = current_time;
        this.min_time = min_time;
        this.fill_time = fill_time;
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int get_min_time() {
        return min_time;
    }

    public void set_min_time(int min_time) {
        this.min_time = min_time;
    }

    public int getFill_time() {
        return fill_time;
    }

    public void setFill_time(int fill_time) {
        this.fill_time = fill_time;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public int getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(int current_time) {
        this.current_time = current_time;
    }

}