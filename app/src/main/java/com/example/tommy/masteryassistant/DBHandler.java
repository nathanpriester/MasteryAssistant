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
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TIMECOMPLETED = "timeCompleted";
    public static final String COLUMN_DESIREDMASTERYLEVEL = "desiredMasteryLevel";
    public static final String COLUMN_WEEKLYGOAL = "weeklyGoal";
    public static final String COLUMN_WEEKLYGOALPROGRESS = "weeklyGoalProgress";
    public static final String COLUMN_WEEKLYGOALSTARTED = "weeklyGoalStarted";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_SKILLS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " TEXT," +
                COLUMN_TIMECOMPLETED + " INTEGER," +
                COLUMN_DESIREDMASTERYLEVEL + " INTEGER," +
                COLUMN_WEEKLYGOAL + " INTEGER," +
                COLUMN_WEEKLYGOALPROGRESS + " INTEGER," +
                COLUMN_WEEKLYGOALSTARTED + " INTEGER" +
                " );";
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
        values.put(COLUMN_WEEKLYGOALSTARTED, 2);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_SKILLS, null, values);
        db.close();
    }

    public Cursor getInformation(SQLiteDatabase db){
        String[] projection = {COLUMN_NAME, COLUMN_TIMECOMPLETED, COLUMN_DESIREDMASTERYLEVEL,
                            COLUMN_WEEKLYGOAL, COLUMN_WEEKLYGOALPROGRESS, COLUMN_WEEKLYGOALSTARTED};
        Cursor cursor = db.query(TABLE_SKILLS, projection, null, null, null, null, null);
        return cursor;
    }

    public void deleteSkill(String skillName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SKILLS + " WHERE " + COLUMN_NAME + "=\"" + skillName + "\";");
        //db.execSQL("DELETE * FROM " + TABLE_SKILLS);
        //db.execSQL("DELETE FROM " + TABLE_SKILLS + " WHERE " + COLUMN_NAME + "=\"" + skillName + "\";");
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
            if (recordSet.getString(recordSet.getColumnIndex("name")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("name"));
                dbString += "  " + recordSet.getString(recordSet.getColumnIndex("timeCompleted"));
                dbString += "  " + recordSet.getString(recordSet.getColumnIndex("desiredMasteryLevel"));
                dbString += "  " + recordSet.getString(recordSet.getColumnIndex("weeklyGoal"));
                dbString += "  " + recordSet.getString(recordSet.getColumnIndex("weeklyGoalProgress"));
                dbString += "  " + recordSet.getString(recordSet.getColumnIndex("weeklyGoalStarted"));
                dbString += "\n";
            }
            recordSet.moveToNext();

        }
        db.close();
        return dbString;
    }

}