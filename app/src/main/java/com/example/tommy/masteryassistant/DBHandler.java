package com.example.tommy.masteryassistant;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

/**
 * Created by Nathan on 10/10/2016.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "skills.db";
    public static final String TABLE_SKILLS = "skills";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "_name";
    public static final String COLUMN_TIMECOMPLETED = "_timeCompleted";
    public static final String COLUMN_DESIREDMASTERYLEVEL = "_desiredMasteryLevel";
    public static final String COLUMN_WEEKLYGOAL = "_weeklyGoal";
    public static final String COLUMN_WEEKLYGOALPROGRESS = "_weeklyGoalProgress";
    public static final String COLUMN_WEEKLYGOALSTARTED = "_weeklyGoalStarted";


    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_SKILLS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_NAME + " TEXT " +
                COLUMN_TIMECOMPLETED + " INTEGER " +
                COLUMN_DESIREDMASTERYLEVEL + " INTEGER " +
                COLUMN_WEEKLYGOAL + " INTEGER " +
                COLUMN_WEEKLYGOALPROGRESS + " INTEGER " +
                COLUMN_WEEKLYGOALSTARTED + " INTEGER " +
                ");";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SKILLS);
        onCreate(sqLiteDatabase);
    }

    public void addSkill(Skill skill){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, skill.get_name());
        values.put(COLUMN_TIMECOMPLETED, skill.get_timeCompleted());
        values.put(COLUMN_DESIREDMASTERYLEVEL, skill.get_desiredMasteryLevel());
        values.put(COLUMN_WEEKLYGOAL, skill.get_weeklyGoal());
        values.put(COLUMN_WEEKLYGOALPROGRESS, 0);
        values.put(COLUMN_WEEKLYGOALSTARTED, skill.get_weeklyGoalStarted());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_SKILLS, null, values);
        db.close();
    }

    public void deleteSkill(String skillName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SKILLS + " WHERE " + COLUMN_NAME + "=\"" + skillName + "\";");
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_SKILLS + " WHERE 1";// why not leave out the WHERE  clause?

        //Cursor points to a location in your results
        Cursor recordSet = db.rawQuery(query, null);
        //Move to the first row in your results
        recordSet.moveToFirst();

        //Position after the last row means the end of the results
        while (!recordSet.isAfterLast()) {
            // null could happen if we used our empty constructor
            if (recordSet.getString(recordSet.getColumnIndex("_name")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("_name"));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }

}
