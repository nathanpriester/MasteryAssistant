package com.example.tommy.masteryassistant;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nathan on 10/30/2016.
 */

public class Preferences {
    private SharedPreferences sharedPreferences;
    private static String PREF_NAME = "prefs";

    public Preferences() {
        // Blank
    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static String getCurrentSkill(Context context) {
        return getPrefs(context).getString("current_skill", "No Current Skill Set");
    }

    public static void setCurrentSkill(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("current_skill", input);
        editor.commit();
    }
}