package com.example.tommy.masteryassistant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nathan on 11/11/16.
 */

public class Milestone_Helper {
    int[] level_hours = {35, 180, 425, 770, 1215, 1760, 2405, 3150, 3995, 4940, 5985, 7130,
            8375, 9270, 10000};

    String[] levels = {"Beginner", "Novice", "Rookie", "Apprentice", "Talented", "Skilled", "Adept", "Skillful", "Seasoned",
            "Proficient", "Experienced", "Advanced", "Senior", "Expert", "Master"};

    String[] Beginner_ranks = {"I", "II", "III", "IV", "V"};
    String[] General_ranks = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    int[] Beginner_ranks_times = {5,11,18,26,35};
    int[] Novice_ranks_times = {45,56,68,81,95,110,126,143,161,180};
    int[] Rookie_ranks_times = {200,321,243,266,290,315,341,368,396,425};
    int[] Apprentice_ranks_times = {455,486,518,551,585,620,656,693,731,770};
    int[] Talented_ranks_times = {810,850,893,936,980,1025,1071,1118,1166,1215};
    int[] Skilled_ranks_times = {1265,1316,1368,1421,1475,1530,1586,1643,1701,1760};
    int[] Adept_ranks_times = {1820,1881,1943,2006,2070,2135,2201,2268,2336,2405};
    int[] Skillful_ranks_times = {2475,2546,2618,2691,2765,2840,2916,2993,3071,3150};
    int[] Seasoned_ranks_times = {3230,3311,3393,3476,3560,3645,3731,3818,3906,3995};
    int[] Proficient_ranks_times = {4085,4176,4268,4361,4455,4550,4646,4743,4841,4940};
    int[] Experienced_ranks_times = {5040,5141,5243,5346,5450,5555,5661,5768,5876,5985};
    int[] Advanced_ranks_times = {6095,6206,6318,6431,6545,6660,6776,6893,7011,7130};
    int[] Senior_ranks_times = {7250,7371,7493,7616,7740,7865,7991,8118,8246,8375};
    int[] Expert_ranks_times = {8505,8636,8768,8901,9035,9170,9306,9443,9581,9720};
    int[] Master_ranks_times = {10000};

    public Milestone_Helper() {}

    public String getLevel(int time){
        for(int i = 0; i < 15; i++){
            if(time < (level_hours[i] * 3600)){
                return levels[i];
            }
        }
        return levels[14];
    }

    public String getCompletedLevel(int time){
        for(int i = 0; i < 15; i++){
            if(time < (level_hours[i] * 3600)){
                return levels[i - 1];
            }
        }
        return levels[14];
    }

    public int getLevelHours(int time){
        String level = getLevel(time);
        for(int i = 0; i < 15; i++){
            if(level.equals(levels[i])){
                return level_hours[i];
            }
        }
        return 0;
    }

    public String getRank(int time){
        String level = getLevel(time);
        if(level.equals("Beginner")){
            for(int i = 0; i < 5; i++){
                if(time < Beginner_ranks_times[i] * 3600){
                    return Beginner_ranks[i];
                }
            }
        }
        if(level.equals("Novice")){
            for(int i = 0; i < 10; i++){
                if(time < Novice_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Rookie")){
            for(int i = 0; i < 10; i++){
                if(time < Rookie_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Apprentice")){
            for(int i = 0; i < 10; i++){
                if(time < Apprentice_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Talented")){
            for(int i = 0; i < 10; i++){
                if(time < Talented_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Skilled")){
            for(int i = 0; i < 10; i++){
                if(time < Skilled_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Adept")){
            for(int i = 0; i < 10; i++){
                if(time < Adept_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Skillful")){
            for(int i = 0; i < 10; i++){
                if(time < Skillful_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Seasoned")){
            for(int i = 0; i < 10; i++){
                if(time < Seasoned_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Proficient")){
            for(int i = 0; i < 10; i++){
                if(time < Proficient_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Experienced")){
            for(int i = 0; i < 10; i++){
                if(time < Experienced_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Advanced")){
            for(int i = 0; i < 10; i++){
                if(time < Advanced_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Senior")){
            for(int i = 0; i < 10; i++){
                if(time < Senior_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Expert")){
            for(int i = 0; i < 10; i++){
                if(time < Expert_ranks_times[i] * 3600){
                    return General_ranks[i];
                }
            }
        }
        if(level.equals("Master")){
            return General_ranks[0];
        }
        return "I";
    }

    public int getLevelProgress(int time){
        String level = getLevel(time);
        int max_time = getLevelHours(time) * 3600;
        double output = ((double)time / (double)max_time) * 100;
        return (int) output;

    }

    public int getRankMax(int time){
        String level = getLevel(time);
        if(level.equals("Beginner")){
            for(int i = 0; i < 5; i++){
                if(time < Beginner_ranks_times[i] * 3600){
                    return Beginner_ranks_times[i];
                }
            }
        }
        if(level.equals("Novice")){
            for(int i = 0; i < 10; i++){
                if(time < Novice_ranks_times[i] * 3600){
                    return Novice_ranks_times[i];
                }
            }
        }
        if(level.equals("Rookie")){
            for(int i = 0; i < 10; i++){
                if(time < Rookie_ranks_times[i] * 3600){
                    return Rookie_ranks_times[i];
                }
            }
        }
        if(level.equals("Apprentice")){
            for(int i = 0; i < 10; i++){
                if(time < Apprentice_ranks_times[i] * 3600){
                    return Apprentice_ranks_times[i];
                }
            }
        }
        if(level.equals("Talented")){
            for(int i = 0; i < 10; i++){
                if(time < Talented_ranks_times[i] * 3600){
                    return Talented_ranks_times[i];
                }
            }
        }
        if(level.equals("Skilled")){
            for(int i = 0; i < 10; i++){
                if(time < Skilled_ranks_times[i] * 3600){
                    return Skilled_ranks_times[i];
                }
            }
        }
        if(level.equals("Adept")){
            for(int i = 0; i < 10; i++){
                if(time < Adept_ranks_times[i] * 3600){
                    return Adept_ranks_times[i];
                }
            }
        }
        if(level.equals("Skillful")){
            for(int i = 0; i < 10; i++){
                if(time < Skillful_ranks_times[i] * 3600){
                    return Skillful_ranks_times[i];
                }
            }
        }
        if(level.equals("Seasoned")){
            for(int i = 0; i < 10; i++){
                if(time < Seasoned_ranks_times[i] * 3600){
                    return Seasoned_ranks_times[i];
                }
            }
        }
        if(level.equals("Proficient")){
            for(int i = 0; i < 10; i++){
                if(time < Proficient_ranks_times[i] * 3600){
                    return Proficient_ranks_times[i];
                }
            }
        }
        if(level.equals("Experienced")){
            for(int i = 0; i < 10; i++){
                if(time < Experienced_ranks_times[i] * 3600){
                    return Experienced_ranks_times[i];
                }
            }
        }
        if(level.equals("Advanced")){
            for(int i = 0; i < 10; i++){
                if(time < Advanced_ranks_times[i] * 3600){
                    return Advanced_ranks_times[i];
                }
            }
        }
        if(level.equals("Senior")){
            for(int i = 0; i < 10; i++){
                if(time < Senior_ranks_times[i] * 3600){
                    return Senior_ranks_times[i];
                }
            }
        }
        if(level.equals("Expert")){
            for(int i = 0; i < 10; i++){
                if(time < Expert_ranks_times[i] * 3600){
                    return Expert_ranks_times[i];
                }
            }
        }
        if(level.equals("Master")){
            return Master_ranks_times[0];
        }
        return 10000;
    }

    public int getRankProgress(int time){
        int rank_max = getRankMax(time) * 3600;
        double output = (double)time;
        output = (output / (double)rank_max) * 100;
        return (int) output;
    }
}