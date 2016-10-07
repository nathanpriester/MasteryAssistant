package com.example.tommy.masteryassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Tommy on 9/27/2016.
 * comment added by nathan asdfasdf
 */

public class Create_Skills extends Activity {

    Button save;
    ArrayList<String> addArray = new ArrayList<String>();
    EditText txt;
    ListView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_skills);

        txt = (EditText)findViewById(R.id.text_input);
        show = (ListView)findViewById(R.id.sample_list);
        save = (Button)findViewById(R.id.button_save);
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
    }
}
