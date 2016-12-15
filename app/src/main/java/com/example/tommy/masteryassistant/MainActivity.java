package com.example.tommy.masteryassistant;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;

/* testing github from nathans laptop with this comment */
public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private ViewFlipper flip;
    private float initialX;
    private TextView CurrentSkill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build(); //PUT BACK

        //IMAGE SWITHER CODE
        flip = (ViewFlipper) findViewById(R.id.viewFlipper1);

        // Setting IN and OUT animation for view flipper
        flip.setInAnimation(this, R.anim.right_enter);
        flip.setOutAnimation(this, R.anim.left_out);
        CurrentSkill = (TextView)findViewById(R.id.currentSkillMainMenu);
        CurrentSkill.setText(Preferences.getCurrentSkill(this));
    }

    //SHARE BUTTON STUFF
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share, menu);
        MenuItem shareItem = menu.findItem(R.id.action_share);

        ShareActionProvider mShare = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Achieve Your Mastery Goals with Mastery Assistant!");

        mShare.setShareIntent(shareIntent);

        return true;

    }
    /*
        // Determines if Action bar item was selected. If true then do corresponding action.
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            //handle presses on the action bar items
            switch (item.getItemId()) {

                case R.id.activity_share:
                    startActivity(new Intent(this, Share.class));
                    return true;

            }
            return super.onOptionsItemSelected(item);
        }
    */
    // Implementing touch event for view flipper
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                // Getting intitial by event action down
                initialX = event.getX();
                break;

            case MotionEvent.ACTION_UP:

                // On action up the flipper will start and showing next item
                float finalX = event.getX();
                if (initialX > finalX) {

                    // Show items are 4
                    if (flip.getDisplayedChild() == 6)
                        break;

                    // Flip show next will show next item
                    flip.setInAnimation(this, R.anim.right_enter);
                    flip.setOutAnimation(this, R.anim.left_out);
                    flip.showNext();
                } else {

                    // If flip has no items more then it will display previous item
                    if (flip.getDisplayedChild() == 0)
                        break;
                    flip.setInAnimation(this, R.anim.right_out);
                    flip.setOutAnimation(this, R.anim.left_enter);
                    flip.showPrevious();
                }
                break;
        }
        return false;
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
            if (Preferences.getCurrentSkill(this) == "No Current Skill Set")
                Toast.makeText(getBaseContext(), "Create a Skill!", Toast.LENGTH_SHORT).show();
            else {
                Intent hub = new Intent(MainActivity.this, Skill_Hub.class);
                startActivity(hub);
            }
        }

    }

    public void onButton_Milestones(View v) {

        if (v.getId() == R.id.button_milestones) {
            if (Preferences.getCurrentSkill(this) == "No Current Skill Set")
                Toast.makeText(getBaseContext(), "Create a Skill!", Toast.LENGTH_SHORT).show();
            else {
                Intent milestone1 = new Intent(MainActivity.this, Milestones.class);
                startActivity(milestone1);
            }
        }

    }

    public void onButton_View_Skills(View v) {

        if (v.getId() == R.id.button_viewskills) {
            if (Preferences.getCurrentSkill(this) == "No Current Skill Set")
                Toast.makeText(getBaseContext(), "Create a Skill!", Toast.LENGTH_SHORT).show();
            else {
                Intent viewskills = new Intent(MainActivity.this, View_Skills.class);
                startActivity(viewskills);
            }
        }

    }

    public void onButton_Progress(View v) {

        if (v.getId() == R.id.button_progress) {
            if (Preferences.getCurrentSkill(this) == "No Current Skill Set")
                Toast.makeText(getBaseContext(), "Create a Skill!", Toast.LENGTH_SHORT).show();
            else {
                Intent newactivity = new Intent(MainActivity.this, Calendar.class);
                startActivity(newactivity);
            }
        }

    }

    public void onButton_Settings(View v) {

        if (v.getId() == R.id.button_settings) {
            if (Preferences.getCurrentSkill(this) == "No Current Skill Set")
                Toast.makeText(getBaseContext(), "Create a Skill!", Toast.LENGTH_SHORT).show();
            else {
                Intent settings1 = new Intent(MainActivity.this, Settings.class);
                startActivity(settings1);
            }
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