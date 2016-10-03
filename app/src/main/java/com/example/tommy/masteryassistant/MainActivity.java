package com.example.tommy.masteryassistant;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

/* testing github from nathans laptop with this comment */
public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //Functional Button
    public void onButton_Create_Skills(View v) {

        if (v.getId() == R.id.button_createskill) {
            Intent create = new Intent(MainActivity.this, Create_Skills.class);
            startActivity(create);
        }

    }

    public void onButton_Skill_Hub(View v) {

        if (v.getId() == R.id.button_skillhub) {
            Intent hub = new Intent(MainActivity.this, Skill_Hub.class);
            startActivity(hub);
        }

    }

    public void onButton_Milestones(View v) {

        if (v.getId() == R.id.button_milestones) {
            Intent milestone1 = new Intent(MainActivity.this, Milestones.class);
            startActivity(milestone1);
        }

    }

    public void onButton_View_Skills(View v) {

        if (v.getId() == R.id.button_viewskills) {
            Intent viewskills = new Intent(MainActivity.this, View_Skills.class);
            startActivity(viewskills);
        }

    }

    public void onButton_Progress(View v) {

        if (v.getId() == R.id.button_progress) {
            Intent prog = new Intent(MainActivity.this, Progress.class);
            startActivity(prog);
        }

    }

    public void onButton_Settings(View v) {

        if (v.getId() == R.id.button_settings) {
            Intent settings1 = new Intent(MainActivity.this, Settings.class);
            startActivity(settings1);
        }

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
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
