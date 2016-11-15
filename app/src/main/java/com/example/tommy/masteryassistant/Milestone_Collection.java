package com.example.tommy.masteryassistant;

import java.util.ArrayList;

/**
 * Created by Danie_000 on 10/28/2016.
 */

public class Milestone_Collection {


    String level;
    ArrayList<Milestone_Object> milestones_set = new ArrayList<>();

    public Milestone_Collection() {

    }

    public Milestone_Collection(ArrayList<Milestone_Object> milestones_set) {
        this.milestones_set = milestones_set;
    }

    public ArrayList<Milestone_Object> getMilestones_set() {
        return milestones_set;
    }

    public void setMilestones_set(ArrayList<Milestone_Object> milestones_set) {
        this.milestones_set = milestones_set;
    }

    public void addMilestone(Milestone_Object milestone){
        milestones_set.add(milestone);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int size(){
        return milestones_set.size();
    }
}