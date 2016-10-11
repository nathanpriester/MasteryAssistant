package com.example.tommy.masteryassistant;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

/**
 * Created by Tommy on 9/27/2016.
 * comment added by nathan asdfasdf
 */

public class Create_Skills extends Activity {

    Button save, delete;
    EditText name, hours, weeklygoal;
    TextView dbText;
    //ListView show;
    DBHandler dbHandler;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_skills);

        name = (EditText) findViewById(R.id.skillName);
        hours = (EditText) findViewById(R.id.documentedHours);
        weeklygoal = (EditText) findViewById(R.id.weeklyGoal);
        //show = (ListView)findViewById(R.id.sample_list);
        save = (Button) findViewById(R.id.saveButton);
        delete = (Button) findViewById(R.id.deleteButton);
        dbText = (TextView) findViewById(R.id.textView);

        /*
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();
                if(addArray.contains(getInput)){
                    Toast.makeText(getBaseContext(), "Item Already Added To the Array", Toast.LENGTH_LONG).show();
                }
                else if (getInput == null || getInput.trim().equals("")){
                    Toast.makeText(getBaseContext(), "Input Field is Empty", Toast.LENGTH_LONG).show();
                }
                else{
                    addArray.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Create_Skills.this, android.R.layout.simple_list_item_1, addArray);
                    show.setAdapter(adapter);
                    ((EditText)findViewById(R.id.text_input)).setText(" ");
                }
            }
        });
        */
        dbHandler = new DBHandler(this, null, null, 1);
        printDatabase();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        dbText.setText(dbString);
        name.setText("");
    }

    public void saveButtonClicked(View view) {
        // dbHandler.add needs an object parameter.
        Skill skill = new Skill(name.getText().toString(), 0, 0, 0);
        dbHandler.addSkill(skill);
        printDatabase();
    }

    //Delete items
    public void deleteButtonClicked(View view) {
        // dbHandler delete needs string to find in the db
        String inputText = name.getText().toString();
        dbHandler.deleteSkill(inputText);
        printDatabase();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Create_Skills Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
